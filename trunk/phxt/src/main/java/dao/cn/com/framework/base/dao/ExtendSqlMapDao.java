package cn.com.framework.base.dao;

import org.apache.commons.lang.ClassUtils;
import org.springframework.dao.DataIntegrityViolationException;

import cn.com.framework.exceptions.DataAccessException;
import cn.com.framework.exceptions.DataAccessIntegrityViolationException;

/**
 * @author <a href="mailto:hanbj@neusoft.com">baojun.han </a>
 * @version $Revision 1.1 $ 2008-4-11 上午11:38:05
 */
public class ExtendSqlMapDao extends SqlMapDao {

	public Object getObject(Class clazz, Object obj) throws DataAccessException {
		try {
			String statement = getFindQuery(ClassUtils.getShortClassName(clazz));
			if (obj instanceof String) {
				statement = statement + "ById";
			}
			return getSqlMapClientTemplate().queryForObject(statement, obj);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	public int delete(Class clazz, Object obj)
			throws DataAccessIntegrityViolationException, DataAccessException {

		int ret = 0;
		try {
			String statement = getDeleteQuery(ClassUtils
					.getShortClassName(clazz));
			if (obj instanceof String) {
				statement = statement + "ById";
			}
			ret = getSqlMapClientTemplate().delete(statement, obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataAccessIntegrityViolationException(e);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
		return ret;

	}
}
