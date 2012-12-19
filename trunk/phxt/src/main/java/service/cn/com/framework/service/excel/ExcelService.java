package cn.com.framework.service.excel;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import jxl.read.biff.BiffException;
import cn.com.framework.beans.Result;
import cn.com.framework.beans.order.FsxxBean;
import cn.com.framework.exceptions.BusinessException;
import cn.com.framework.exceptions.DataAccessException;
import cn.com.framework.exceptions.DataAccessIntegrityViolationException;
import cn.com.framework.service.Service;

public interface ExcelService extends Service {
	public String jgMs(ArrayList<FsxxBean> list);

	public void jefj(ArrayList<FsxxBean> list);

	public void jefj(FsxxBean bean);

	public ArrayList<FsxxBean> list(FsxxBean bean) throws DataAccessException;

	public ArrayList<FsxxBean> excelDr(File file, String uploadFileName,
			String uploadContentType) throws BiffException, IOException,
			BusinessException, DataAccessIntegrityViolationException,
			DataAccessException;

	public ArrayList<FsxxBean> queryTjjg() throws DataAccessException;

	public void delete(ArrayList<FsxxBean> beanList)
			throws DataAccessIntegrityViolationException, DataAccessException;

	public ArrayList<FsxxBean> queryListByIds(ArrayList<FsxxBean> list)
			throws DataAccessException;

	public boolean exportExcel(ArrayList<FsxxBean> list,
			HttpServletResponse response);
}
