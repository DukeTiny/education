package com.woniu.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	static ComboPooledDataSource dataSource;
	static{
		dataSource = new ComboPooledDataSource("demo1");
	}
	public static Connection getConn() throws SQLException{
		Connection conn = dataSource.getConnection();
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
