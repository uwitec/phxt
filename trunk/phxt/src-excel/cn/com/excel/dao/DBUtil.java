package cn.com.excel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * ����Ϊ���ݿ⹤���࣬�ṩһϵ�еľ�̬����ʵ�ֶ����ݿ�Ĳ���
 */
public class DBUtil {

	// ������ʹ������Դ���ӳط������ݿ�
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/zyjz",
					"zyjz", "zyjz");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}