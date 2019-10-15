package com.woniu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class JDBCDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=utf8", "root", "woniu");
			Statement stat = conn.createStatement();
			//执行查询语句DQL
			//返回一个结果集
			ResultSet rs = stat.executeQuery("select * from student where sno='101'");
			//访问下一行
			rs.next();
			//rs.getString(int index); 取出一列数据
			System.out.println(rs.getString(2));
			//执行增删改语句DML
//			int num = stat.executeUpdate("insert into a values(6,'bbb')");
			//返回值为影响行数
//			int num = stat.executeUpdate("update a set aname='zzz'");
//			System.out.println(num);
		} catch (ClassNotFoundException e) { //类找不到异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
