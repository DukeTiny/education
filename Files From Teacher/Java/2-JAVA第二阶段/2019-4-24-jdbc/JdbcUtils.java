package com.woniu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	static Connection conn;
	static String url = "jdbc:mysql://localhost:3306/demo?characterEncoding=utf8";
	static String user = "root";
	static String password = "woniu";
	static String driver = "com.mysql.jdbc.Driver";
	public static Connection getConn() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	public static void closeConn(ResultSet rs,Statement stat,Connection conn){
		try {
			if(rs!=null){
					rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
