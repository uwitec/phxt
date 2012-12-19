/*******************************************************************************
 * @(#)WBDTDDataAccessException.java Oct 16, 2007
 *
 * Copyright 2007 Neusoft Group Ltd. All rights reserved.
 * Neusoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package cn.com.framework.exceptions;

/**
 * 数据完整性约束异常（主键冲突、外键关联�?违反唯一性�?。�?�?
 * @author <a href="mailto:wu-fei@neusoft. com">wufei </a>
 * @version $Revision 1.1 $ 2008-1-11 下午02:35:24
 */
public class DataAccessIntegrityViolationException extends Exception {

    private static final long serialVersionUID = 1345111443834498940L;

    public DataAccessIntegrityViolationException() {
        super();
    }

    public DataAccessIntegrityViolationException(Exception e) {
        super(e);
    }

    public DataAccessIntegrityViolationException(String msg) {
        super(msg);
    }

    public DataAccessIntegrityViolationException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
