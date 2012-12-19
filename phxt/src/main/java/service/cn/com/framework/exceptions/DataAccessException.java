/*******************************************************************************
 * @(#)WBDTDDataAccessException.java Oct 16, 2007
 *
 * Copyright 2007 Neusoft Group Ltd. All rights reserved.
 * Neusoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package cn.com.framework.exceptions;

/**
 * 数据访问异常,包括数据库链接异常，等其他异�?
 * @author <a href="mailto:wu-fei@neusoft. com">wufei </a>
 * @version $Revision 1.1 $ 2008-1-11 下午02:35:24
 */
public class DataAccessException extends Exception {

    private static final long serialVersionUID = -2345111443834498940L;

    public DataAccessException() {
        super();
    }

    public DataAccessException(Exception e) {
        super(e);
    }

    public DataAccessException(String msg) {
        super(msg);
    }

    public DataAccessException(String msg, Throwable ex) {
        super(msg, ex);
    }

    public DataAccessException(Throwable t) {
        super(t);
    }
}
