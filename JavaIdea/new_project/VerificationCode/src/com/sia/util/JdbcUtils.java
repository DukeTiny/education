package com.sia.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	public static void closeConn(ResultSet rs,Statement stat,Connection conn){
		try {
			if(rs!=null && !rs.isClosed() ) rs.close();
			if(stat!=null && !stat.isClosed()) stat.close();
			if(conn!=null && !conn.isClosed())conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
