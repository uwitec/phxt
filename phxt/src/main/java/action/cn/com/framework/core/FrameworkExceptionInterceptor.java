package cn.com.framework.core;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import cn.com.framework.exceptions.BusinessException;
import cn.com.framework.exceptions.DataAccessException;
import cn.com.framework.exceptions.DataAccessIntegrityViolationException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.ExceptionMappingInterceptor;

public class FrameworkExceptionInterceptor extends ExceptionMappingInterceptor {
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result;

		try {
			result = invocation.invoke();
		} catch (Exception e) {
			/**
			 * 处理异常
			 */
			String errorMsg = "未知错误！";
			String errorTitle = "出问题了";
			// 通过instanceof判断到底是什么异常类型
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				be.printStackTrace(); // 开发时打印异常信息，方便调试
				if (be.getMessage() != null && be.getMessage().length() > 0) {
					// 获得错误信息
					errorMsg = be.getMessage().trim();
				}
				if (be.getErrorTitle() != null
						&& be.getErrorTitle().length() > 0) {
					errorTitle = be.getErrorTitle();
				}
			} else if (e instanceof DataAccessIntegrityViolationException) {
				// 未知的运行时异常
				DataAccessIntegrityViolationException re = (DataAccessIntegrityViolationException) e;
				re.printStackTrace();
				errorTitle = "数据库数据写入异常";
				errorMsg = re.getMessage();
			} else if (e instanceof DataAccessException) {
				// 未知的运行时异常
				DataAccessException re = (DataAccessException) e;
				re.printStackTrace();
				errorTitle = "数据库访问异常";
				errorMsg = re.getMessage();
			} else if (e instanceof RuntimeException) {
				// 未知的运行时异常
				RuntimeException re = (RuntimeException) e;
				re.printStackTrace();
				errorMsg = re.getMessage();
			} else {
				errorMsg = e.getMessage();
			}
			// 把自定义错误信息
			HttpServletRequest request = (HttpServletRequest) invocation
					.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
			/**
			 * 发送错误消息到页面
			 */
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("errorTitle", errorTitle);
			return "error";
		}

		return result;
	}
}
