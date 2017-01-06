package com.gxk.signle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 单例模式数据库连接
 * 
 * @author gxk
 *
 */
public class JdbcSignle {

	private String url = "jdbc:mysql://localhost:3306/user";
	private String user = "root";
	private String pwd = "guxinkai";
	private static JdbcSignle Singleton;
	Statement  stmt = null;
	Connection conn = null;

	private JdbcSignle() {}

	public static JdbcSignle getInstance() {
		if (Singleton == null) {
			Singleton = new JdbcSignle();
		}
		return Singleton;
	}

	public void getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, pwd);
		String sql = "insert into user values (1,'顾新凯')";
		stmt = conn.createStatement();
		int rs = stmt.executeUpdate(sql);
		System.out.println(rs);
	}

	public void closeConnection() throws Exception {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}
