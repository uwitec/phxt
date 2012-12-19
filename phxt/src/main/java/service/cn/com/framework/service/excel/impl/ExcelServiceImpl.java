package cn.com.framework.service.excel.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import cn.com.framework.beans.order.FsxxBean;
import cn.com.framework.exceptions.BusinessException;
import cn.com.framework.exceptions.DataAccessException;
import cn.com.framework.exceptions.DataAccessIntegrityViolationException;
import cn.com.framework.service.excel.ExcelService;
import cn.com.framework.service.impl.ServiceImpl;

public class ExcelServiceImpl extends ServiceImpl implements ExcelService {
	public String jgMs(ArrayList<FsxxBean> list) {
		int pmje100Total = 0;
		int pmje50Total = 0;
		int pmje20Total = 0;
		for (FsxxBean bean : list) {
			pmje100Total += Integer.valueOf(bean.getPmje100());
			pmje50Total += Integer.valueOf(bean.getPmje50());
			pmje20Total += Integer.valueOf(bean.getPmje20());
		}
		return "您本次需要领购 票面金额为100元的发票：" + pmje100Total + "张，" + "票面金额为50元的发票："
				+ pmje50Total + "张，票面金额20元的发票：" + pmje20Total + "张";
	}

	public void jefj(ArrayList<FsxxBean> list) {
		for (FsxxBean bean : list) {
			this.jefj(bean);
		}
	}

	/**
	 * 对金额进行分解 分解结果写入FsxxBean pmje100 pmje50 pmje20 字段中
	 * 
	 * @param bean
	 */
	public void jefj(FsxxBean bean) {
		double je = Double.valueOf(bean.getJe());
		double first = je / 100;
		int pmje100 = (int) Math.floor(first);
		int pmje50 = 0;
		int pmje20 = 0;
		double second = je - pmje100 * 100;
		if (second > 0 && second <= 20) {
			pmje50 = 0;
			pmje20 = 1;
		} else if (second > 20 && second <= 40) {
			pmje50 = 0;
			pmje20 = 2;
		} else if (second > 40 && second <= 50) {
			pmje50 = 1;
			pmje20 = 0;
		} else if (second > 50 && second <= 60) {
			pmje50 = 0;
			pmje20 = 3;
		} else if (second > 60 && second <= 70) {
			pmje50 = 1;
			pmje20 = 1;
		} else if (second > 70 && second <= 80) {
			pmje50 = 0;
			pmje20 = 4;
		} else if (second > 80 && second <= 90) {
			pmje50 = 1;
			pmje20 = 2;
		} else if (second > 90 && second <= 100) {
			pmje50 = 0;
			pmje20 = 0;
			pmje100 = pmje100 + 1;
		}
		bean.setPmje100(String.valueOf(pmje100));
		bean.setPmje20(String.valueOf(pmje20));
		bean.setPmje50(String.valueOf(pmje50));
	}

	public ArrayList<FsxxBean> list(FsxxBean bean) throws DataAccessException {
		if (bean == null) {
			bean = new FsxxBean();
		}
		ArrayList<FsxxBean> list = (ArrayList<FsxxBean>) dao.getObjects(
				"Fsxx.getAllOrders", bean);
		return list;
	}

	public ArrayList<FsxxBean> excelDr(File file, String uploadFileName,
			String uploadContentType) throws BiffException, IOException,
			BusinessException, DataAccessIntegrityViolationException,
			DataAccessException {
		FileInputStream fis = new FileInputStream(file);
		Workbook book = Workbook.getWorkbook(fis);
		// 得到第一个工作表对象
		Sheet sheet = book.getSheet(0);
		// 得到第一个工作表中的总行数
		int rowCount = sheet.getRows();
		// 循环取出Excel中的内容
		FsxxBean bean = null;
		ArrayList<FsxxBean> list = new ArrayList<FsxxBean>();
		DateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = ft.format(new Date());
		for (int i = 1; i < rowCount; i++) {
			Cell[] cells = sheet.getRow(i);
			String name = cells[0].getContents();
			String je = cells[1].getContents();
			try {
				double jeT;
				jeT = Double.valueOf(je);
			} catch (Exception e) {
				throw new BusinessException("第" + i + "金额必须是数值类型");
			}
			bean = new FsxxBean();
			bean.setName(name);
			bean.setFileName(uploadFileName);
			bean.setJe(je);
			bean.setDr_time(nowTime);
			dao.insert("Fsxx.insert", bean);
			list.add(bean);
		}
		fis.close();
		return list;
	}

	public ArrayList<FsxxBean> queryTjjg() throws DataAccessException {
		ArrayList<FsxxBean> list = (ArrayList<FsxxBean>) dao.getObjects(
				"Fsxx.getAllFiles", null);
		return list;
	}

	public void delete(ArrayList<FsxxBean> beanList)
			throws DataAccessIntegrityViolationException, DataAccessException {
		if (beanList == null || beanList.size() == 0) {
			return;
		}
		for (FsxxBean bean : beanList) {
			dao.delete("Fsxx.delete", bean.getId());
		}
	}

	public ArrayList<FsxxBean> queryListByIds(ArrayList<FsxxBean> list)
			throws DataAccessException {
		ArrayList<FsxxBean> listNew = new ArrayList<FsxxBean>();
		for (FsxxBean bean : list) {
			listNew.add((FsxxBean) dao.getObject("Fsxx.getAllOrders", bean));
		}
		this.jefj(listNew);
		return listNew;
	}

	/**
	 * 导出为Excel
	 * 
	 * @param cdosCategoryKeyWords
	 * @return
	 */
	public boolean exportExcel(ArrayList<FsxxBean> list,
			HttpServletResponse response) {
		OutputStream os = null;
		try {
			os = response.getOutputStream();
		} catch (IOException e1) {
		}
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String curDatetime = sdf.format(cal.getTime());
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=temp"
				+ curDatetime + ".xls");
		response.setContentType("application/msexcel");
		WritableWorkbook wwb = null;
		WritableSheet ws = null;
		try {
			wwb = Workbook.createWorkbook(os);
			ws = wwb.createSheet("用户发票明细", 0);
			ws.getSettings().setDefaultColumnWidth(15);
			// 创建表头
			WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc);
			wcfFC.setBackground(jxl.format.Colour.GREEN);
			Label nameHeadLabel = new Label(0, 0, "学校名称", wcfFC);
			Label jeHeadLabel = new Label(1, 0, "金额", wcfFC);
			Label fp100ConfigHeadLabel = new Label(2, 0, "100发票数量", wcfFC);
			Label fp50HeadLabel = new Label(3, 0, "50元发票数量", wcfFC);
			Label fp20HeadLabel = new Label(4, 0, "20元发票数量", wcfFC);

			ws.addCell(nameHeadLabel);
			ws.addCell(jeHeadLabel);
			// ws.setColumnView(2, 50);
			ws.addCell(fp100ConfigHeadLabel);
			ws.addCell(fp50HeadLabel);
			ws.addCell(fp20HeadLabel);

			Label nameLabel = null;
			Label jeLabel = null;
			Label pmje100Label = null;
			Label pmje50Label = null;
			Label pmje20Label = null;
			for (int i = 1; i < list.size() + 1; i++) {
				String name = list.get(i - 1).getName();
				String je = list.get(i - 1).getJe();
				String pmje100 = list.get(i - 1).getPmje100();
				String pmje50 = list.get(i - 1).getPmje50();
				String pmje20 = list.get(i - 1).getPmje20();
				nameLabel = new Label(0, i, name);
				jeLabel = new Label(1, i, je);
				pmje100Label = new Label(2, i, pmje100);
				WritableCellFormat cellFormat = new WritableCellFormat();
				cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
				pmje100Label.setCellFormat(cellFormat);
				pmje50Label = new Label(3, i, pmje50);
				pmje50Label.setCellFormat(cellFormat);
				pmje20Label = new Label(4, i, pmje20);
				pmje20Label.setCellFormat(cellFormat);
				ws.addCell(nameLabel);
				ws.addCell(jeLabel);
				ws.addCell(pmje100Label);
				ws.addCell(pmje50Label);
				ws.addCell(pmje20Label);
			}
			ws.mergeCells(0, list.size() + 1, 4, list.size() + 1);// 参数格式（开始列，开始行，结束列，结束行）
			String ms = this.jgMs(list);
			WritableCellFormat totalFormat = new WritableCellFormat();
			totalFormat.setBackground(jxl.format.Colour.YELLOW);
			Label lableTotal = new Label(0, list.size() + 1, ms);
			lableTotal.setCellFormat(totalFormat);
			ws.addCell(lableTotal);

		} catch (Exception e) {
			return false;
		} finally {
			try {
				wwb.write();
				wwb.close();
				os.close();
			} catch (WriteException e) {
			} catch (IOException e) {
			}
		}
		return true;
	}
}
