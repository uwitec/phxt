package cn.com.framework.excel;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import jxl.read.biff.BiffException;

import org.apache.struts2.ServletActionContext;

import cn.com.framework.base.BaseAction;
import cn.com.framework.beans.Result;
import cn.com.framework.beans.order.FsxxBean;
import cn.com.framework.exceptions.BusinessException;
import cn.com.framework.exceptions.DataAccessException;
import cn.com.framework.exceptions.DataAccessIntegrityViolationException;
import cn.com.framework.service.excel.ExcelService;

public class ExcelAction extends BaseAction {
	private ExcelService excelService;
	private File upload;
	private FsxxBean bean;
	private ArrayList<FsxxBean> fjjgList;
	private ArrayList<FsxxBean> fileTjjgList;
	private String jg;
	private String uploadFileName;
	private String uploadContentType;

	public String exportExcel() throws DataAccessException {
		HttpServletResponse response = ServletActionContext.getResponse();
		fjjgList = excelService.queryListByIds(fjjgList);
		excelService.exportExcel(fjjgList, response);
		return "list";
	}

	public String exportExcelAll() throws SQLException, DataAccessException {
		ArrayList<FsxxBean> resultList = excelService.list(new FsxxBean());
		HttpServletResponse response = ServletActionContext.getResponse();
		excelService.jefj(resultList);
		excelService.exportExcel(resultList, response);
		return "list";
	}

	public String delete() throws IOException, SQLException,
			DataAccessException, DataAccessIntegrityViolationException {
		excelService.delete(this.getFjjgList());
		this.setEvent("list");
		this.list();
		return "list";
	}

	public String drExcel() throws BiffException, IOException,
			BusinessException, DataAccessIntegrityViolationException,
			DataAccessException {
		if (upload == null) {
			return SUCCESS;
		}
		ArrayList<FsxxBean> resultList = excelService.excelDr(upload,
				uploadFileName, uploadContentType);
		return SUCCESS;
	}

	public String init() {
		return SUCCESS;
	}

	public String list() throws IOException, SQLException, DataAccessException, DataAccessIntegrityViolationException {
		if (this.getEvent() != null && this.getEvent().equals("delete")) {
			return this.delete();
		}
		if (this.getEvent() != null && this.getEvent().equals("exportExcel")) {
			return this.exportExcel();
		}
		if (this.getEvent() != null && this.getEvent().equals("exportExcelAll")) {
			return this.exportExcelAll();
		}
		this.setFileTjjgList(excelService.queryTjjg());
		FsxxBean queryBean = null;
		if (this.getEvent() != null && this.getEvent().equals("list")) {
			queryBean = this.getBean();
		} else {
			if (this.getFileTjjgList().size() > 0) {
				queryBean = this.getFileTjjgList().get(0);
			} else {
				queryBean = this.getBean();
			}
		}
		ArrayList<FsxxBean> fjjgList = excelService.list(queryBean);
		excelService.jefj(fjjgList);
		this.setFjjgList(fjjgList);
		this.setJg(excelService.jgMs(fjjgList));
		return "list";
		// 
		// JSONArray jsonArray = JSONArray.fromObject(list);
		// String s = jsonArray.toString();
		// s = "{\"rows\":" + s + ",\"total\":" + list.size() + "}";
		// System.out.println(s);
		// response.setCharacterEncoding("UTF-8");
		// response.getWriter().write(s);
		// return SUCCESS;
	}

	public String upload() {
		return SUCCESS;
	}

	public ExcelService getExcelService() {
		return excelService;
	}

	public void setExcelService(ExcelService excelService) {
		this.excelService = excelService;
	}

	public FsxxBean getBean() {
		return bean;
	}

	public void setBean(FsxxBean bean) {
		this.bean = bean;
	}

	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	public ArrayList<FsxxBean> getFjjgList() {
		return fjjgList;
	}

	public void setFjjgList(ArrayList<FsxxBean> fjjgList) {
		this.fjjgList = fjjgList;
	}

	public ArrayList<FsxxBean> getFileTjjgList() {
		return fileTjjgList;
	}

	public void setFileTjjgList(ArrayList<FsxxBean> fileTjjgList) {
		this.fileTjjgList = fileTjjgList;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

}
