/*******************************************************************************
 * @(#)OperationLogger.java 2008-4-18
 *
 * Copyright 2008 Neusoft Group Ltd. All rights reserved.
 * Neusoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package cn.com.framework.log;

import cn.com.framework.system.User;

public interface OperateLogRecorder {

	String MALS_USER_OPERATION_LOG = "MALS_USER_OPERATION_LOG";

	String MALS_USER_OPER_TYPE = "MALS_USER_OPER_TYPE";

	void record(User user, String ipAddr, String actiondesc, String type);
}
