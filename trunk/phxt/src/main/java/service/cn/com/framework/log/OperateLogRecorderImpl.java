package cn.com.framework.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.framework.system.User;

public class OperateLogRecorderImpl implements OperateLogRecorder {

	private static final long serialVersionUID = -4108810191966829778L;

	private final Log log = LogFactory.getLog(OperateLogRecorderImpl.class);

	@Override
	public void record(User user, String ipAddr, String actiondesc, String type) {
		// TODO Auto-generated method stub
		
	}

}
