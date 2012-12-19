/*******************************************************************************
 * @(#)WBDTDBusinessException.java Oct 16, 2007
 *
 * Copyright 2007 Neusoft Group Ltd. All rights reserved.
 * Neusoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package cn.com.framework.exceptions;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -395519744859162811L;
	private String errorTitle = "";

	public BusinessException() {
		super();
	}

	public BusinessException(Exception e) {
		super(e);
	}

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(String title, String msg) {
		super(msg);
		this.setErrorTitle(title);
	}

	public BusinessException(String msg, Throwable ex) {
		super(msg, ex);
	}

	public String getErrorTitle() {
		return errorTitle;
	}

	public void setErrorTitle(String errorTitle) {
		this.errorTitle = errorTitle;
	}
}
