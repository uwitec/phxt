/**
 * @author <a href="hegq@neusoft.com">Puras.He</a>
 * @version Revision: 1.1 Date: Oct 15, 2007
 */
package cn.com.framework.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.framework.base.dao.Dao;
import cn.com.framework.exceptions.BusinessException;
import cn.com.framework.exceptions.DataAccessException;
import cn.com.framework.exceptions.DataAccessIntegrityViolationException;
import cn.com.framework.service.Service;


/**
 * @author <a href="hegq@neusoft.com">Puras.He</a>
 * @version Revision: 1.1 Date: Oct 15, 2007 4:22:36 PM
 */

/**
 * @author Puras.He
 */
public class ServiceImpl implements Service {

    // 该数据已经存
    private static final String INFO_INTEGRITY_VIOLATION_ERROR = "info.integrity.violation.error";

    private static final String INFO_DB_ERROR = "info.db.error"; // 数据库访问错

    protected static final Log LOG = LogFactory.getLog(ServiceImpl.class);

    protected Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Object getObject(Class clazz, Object obj) throws BusinessException {
        try {
            return dao.getObject(clazz, obj);
        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public Object getObject(String statment, Object obj) throws BusinessException {
        try {
            return dao.getObject(statment, obj);
        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public List getObjects(Class clazz, Object obj) throws BusinessException {
        try {
            return dao.getObjects(clazz, obj);
        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public List getObjects(String statement, Object obj) throws BusinessException {
        try {
            return dao.getObjects(statement, obj);
        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public List getObjectsByPage(Class clazz, Object obj, int skipResults, int maxResults)
            throws BusinessException {
        try {
            return dao.getObjectsByPage(clazz, obj, skipResults, maxResults);
        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public void insert(Class clazz, Object obj) throws BusinessException {
        try {
            dao.insert(clazz, obj);
        } catch (DataAccessIntegrityViolationException e) {
            LOG.error(e);
            throw new BusinessException(INFO_INTEGRITY_VIOLATION_ERROR);

        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public void insert(String statment, Object obj) throws BusinessException {
        try {
            dao.insert(statment, obj);
        } catch (DataAccessIntegrityViolationException e) {
            LOG.error(e);
            throw new BusinessException(INFO_INTEGRITY_VIOLATION_ERROR);

        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public int update(Class clazz, Object obj) throws BusinessException {
        try {
            return dao.update(clazz, obj);
        } catch (DataAccessIntegrityViolationException e) {
            LOG.error(e);
            throw new BusinessException(INFO_INTEGRITY_VIOLATION_ERROR);

        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public int update(String statment, Object obj) throws BusinessException {
        try {
            return dao.delete(statment, obj);
        } catch (DataAccessIntegrityViolationException e) {
            LOG.error(e);
            throw new BusinessException(INFO_INTEGRITY_VIOLATION_ERROR);

        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public int delete(Class clazz, Object obj) throws BusinessException {
        try {
            return dao.delete(clazz, obj);
        } catch (DataAccessIntegrityViolationException e) {
            LOG.error(e);
            throw new BusinessException(INFO_INTEGRITY_VIOLATION_ERROR);

        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public int delete(String statment, Object obj) throws BusinessException {
        try {
            return dao.delete(statment, obj);
        } catch (DataAccessIntegrityViolationException e) {
            LOG.error(e);
            throw new BusinessException(INFO_INTEGRITY_VIOLATION_ERROR);

        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }

    public int getCount(Class clazz, Object obj) throws BusinessException {
        try {
            return dao.getCount(clazz, obj);
        } catch (DataAccessException e) {
            LOG.error(e);
            throw new BusinessException(INFO_DB_ERROR);
        }
    }
}
