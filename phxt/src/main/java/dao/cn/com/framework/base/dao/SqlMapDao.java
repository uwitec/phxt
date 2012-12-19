package cn.com.framework.base.dao;

import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.com.framework.exceptions.DataAccessException;
import cn.com.framework.exceptions.DataAccessIntegrityViolationException;

public class SqlMapDao extends SqlMapClientDaoSupport implements Dao {

	public Object getObject(String statment, Object obj)
			throws DataAccessException {
		try {
			return getSqlMapClientTemplate().queryForObject(statment, obj);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public List getObjects(String statement, Object obj)
			throws DataAccessException {
		try {
			return getSqlMapClientTemplate().queryForList(statement, obj);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public Object getObject(Class clazz, Object obj) throws DataAccessException {
		try {
			return getSqlMapClientTemplate().queryForObject(
					getFindQuery(ClassUtils.getShortClassName(clazz)), obj);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public List getObjects(Class clazz, Object obj) throws DataAccessException {
		try {
			return getSqlMapClientTemplate().queryForList(
					getSelectQuery(ClassUtils.getShortClassName(clazz)), obj);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public List getObjectsByPage(Class clazz, Object obj, int skipResults,
			int maxResults) throws DataAccessException {
		try {
			return getSqlMapClientTemplate().queryForList(
					getSelectQuery(ClassUtils.getShortClassName(clazz)), obj,
					skipResults, maxResults);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public List getObjectsByPage(String statment, Object obj, int skipResults,
			int maxResults) throws DataAccessException {
		try {
			return getSqlMapClientTemplate().queryForList(statment, obj,
					skipResults, maxResults);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public Object insert(Class clazz, Object obj)
			throws DataAccessIntegrityViolationException, DataAccessException {
		try {
			return getSqlMapClientTemplate().insert(
					getInsertQuery(ClassUtils.getShortClassName(clazz)), obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataAccessIntegrityViolationException(e);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	/**
	 * @param statment
	 * @param obj
	 * @throws DataAccessIntegrityViolationException
	 * @throws DataAccessException
	 */
	public Object insert(String statment, Object obj)
			throws DataAccessIntegrityViolationException, DataAccessException {
		try {
			return getSqlMapClientTemplate().insert(statment, obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataAccessIntegrityViolationException(e);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	/**
	 * @param statment
	 * @param obj
	 * @return
	 * @throws DataAccessIntegrityViolationException
	 * @throws DataAccessException
	 */
	public int update(String statment, Object obj)
			throws DataAccessIntegrityViolationException, DataAccessException {
		int ret = 0;
		try {
			ret = getSqlMapClientTemplate().update(statment, obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataAccessIntegrityViolationException(e);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
		return ret;
	}

	public int update(Class clazz, Object obj)
			throws DataAccessIntegrityViolationException, DataAccessException {
		int ret = 0;
		try {
			ret = getSqlMapClientTemplate().update(
					getUpdateQuery(ClassUtils.getShortClassName(clazz)), obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataAccessIntegrityViolationException(e);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
		return ret;
	}

	/**
	 * @param statment
	 * @param obj
	 * @return
	 * @throws DataAccessIntegrityViolationException
	 * @throws DataAccessException
	 */
	public int delete(String statment, Object obj)
			throws DataAccessIntegrityViolationException, DataAccessException {
		int ret = 0;
		try {
			ret = getSqlMapClientTemplate().delete(statment, obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataAccessIntegrityViolationException(e);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
		return ret;

	}

	public int delete(Class clazz, Object obj)
			throws DataAccessIntegrityViolationException, DataAccessException {

		int ret = 0;
		try {
			ret = getSqlMapClientTemplate().delete(
					getDeleteQuery(ClassUtils.getShortClassName(clazz)), obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataAccessIntegrityViolationException(e);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
		return ret;

	}

	public int getCount(Class clazz, Object obj) throws DataAccessException {
		try {
			return ((Integer) getSqlMapClientTemplate().queryForObject(
					getCountQuery(ClassUtils.getShortClassName(clazz)), obj))
					.intValue();
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public List getObjects(Object statement, Object obj)
			throws DataAccessException {
		try {
			return getSqlMapClientTemplate().queryForList((String) statement,
					obj);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	protected String getFindQuery(String className) {
		return className + ".get" + className;
	}

	protected String getSelectQuery(String className) {
		return className + ".get" + className + "s";
	}

	protected String getInsertQuery(String className) {
		return className + ".insert";
	}

	protected String getUpdateQuery(String className) {
		return className + ".update";
	}

	protected String getDeleteQuery(String className) {
		return className + ".delete";
	}

	protected String getCountQuery(String className) {
		return className + ".getCount";
	}
}
