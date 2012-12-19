package cn.com.excel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 该类为数据库工具类，提供一系列的静态方法实现对数据库的操作
 */
public class DBUtil {

	// 方法：使用数据源连接池访问数据库
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