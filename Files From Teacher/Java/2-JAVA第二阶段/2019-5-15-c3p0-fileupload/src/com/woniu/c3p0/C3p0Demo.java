package com.woniu.c3p0;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniu.util.JdbcUtils;

public class C3p0Demo {

	public static void main(String[] args) {
		//数据库连接池对象
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
//			Connection conn = dataSource.getConnection();
			PreparedStatement ps = JdbcUtils.getConn().prepareStatement("select * from dept");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
