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
			 * �����쳣
			 */
			String errorMsg = "δ֪����";
			String errorTitle = "��������";
			// ͨ��instanceof�жϵ�����ʲô�쳣����
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				be.printStackTrace(); // ����ʱ��ӡ�쳣��Ϣ���������
				if (be.getMessage() != null && be.getMessage().length() > 0) {
					// ��ô�����Ϣ
					errorMsg = be.getMessage().trim();
				}
				if (be.getErrorTitle() != null
						&& be.getErrorTitle().length() > 0) {
					errorTitle = be.getErrorTitle();
				}
			} else if (e instanceof DataAccessIntegrityViolationException) {
				// δ֪������ʱ�쳣
				DataAccessIntegrityViolationException re = (DataAccessIntegrityViolationException) e;
				re.printStackTrace();
				errorTitle = "���ݿ�����д���쳣";
				errorMsg = re.getMessage();
			} else if (e instanceof DataAccessException) {
				// δ֪������ʱ�쳣
				DataAccessException re = (DataAccessException) e;
				re.printStackTrace();
				errorTitle = "���ݿ�����쳣";
				errorMsg = re.getMessage();
			} else if (e instanceof RuntimeException) {
				// δ֪������ʱ�쳣
				RuntimeException re = (RuntimeException) e;
				re.printStackTrace();
				errorMsg = re.getMessage();
			} else {
				errorMsg = e.getMessage();
			}
			// ���Զ��������Ϣ
			HttpServletRequest request = (HttpServletRequest) invocation
					.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
			/**
			 * ���ʹ�����Ϣ��ҳ��
			 */
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("errorTitle", errorTitle);
			return "error";
		}

		return result;
	}
}
