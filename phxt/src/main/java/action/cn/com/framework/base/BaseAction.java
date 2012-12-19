package cn.com.framework.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.com.framework.exceptions.BusinessException;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	public String resultMessage;
	public boolean isSuccess;
	public String event;
	public String method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
