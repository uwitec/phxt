/*******************************************************************************
 * @(#)Dao.java Oct 16, 2007
 *
 * Copyright 2007 Neusoft Group Ltd. All rights reserved.
 * Neusoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package cn.com.framework.base.dao;

import java.util.List;

import cn.com.framework.exceptions.DataAccessException;
import cn.com.framework.exceptions.DataAccessIntegrityViolationException;


/**
 * @author <a href="hegq@neusoft.com">Puras.He</a>
 * @version Revision: 1.1 Date: Oct 15, 2007 4:05:14 PM
 */
public interface Dao {
    Object getObject(Class clazz, Object obj) throws DataAccessException;

    List getObjects(Class clazz, Object obj) throws DataAccessException;

    List getObjectsByPage(Class clazz, Object obj, int skipResults, int maxResults)
            throws DataAccessException;

    Object insert(Class clazz, Object obj) throws DataAccessIntegrityViolationException,
            DataAccessException;

    int update(Class clazz, Object obj) throws DataAccessIntegrityViolationException,
            DataAccessException;

    int delete(Class clazz, Object obj) throws DataAccessIntegrityViolationException,
            DataAccessException;

    int getCount(Class clazz, Object obj) throws DataAccessException;

    List getObjects(Object statement, Object obj) throws DataAccessException;

    Object insert(String statment, Object obj) throws DataAccessIntegrityViolationException,
            DataAccessException;

    int update(String statment, Object obj) throws DataAccessIntegrityViolationException,
            DataAccessException;

    int delete(String statment, Object obj) throws DataAccessIntegrityViolationException,
            DataAccessException;

    Object getObject(String statment, Object obj) throws DataAccessException;

    List getObjects(String statment, Object obj) throws DataAccessException;

    List getObjectsByPage(String statment, Object obj, int skipResults, int maxResults)
            throws DataAccessException;
}
