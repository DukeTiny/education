package com.woniu.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import javafx.util.converter.PercentageStringConverter;

public class JdbcUtils {
	static String driver;
	static String url;
	static String user;
	static String password;
	static Connection conn;
	static{
		Properties ps = new Properties();
		try {
			ps.load(JdbcUtils.class.getResourceAsStream("db.properties"));
			driver = ps.getProperty("driver");
			url = ps.getProperty("url");
			user = ps.getProperty("user");
			password = ps.getProperty("password");
			Class.forName(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException{
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
