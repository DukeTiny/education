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
			//ִ�в�ѯ���DQL
			//����һ�������
			ResultSet rs = stat.executeQuery("select * from student where sno='101'");
			//������һ��
			rs.next();
			//rs.getString(int index); ȡ��һ������
			System.out.println(rs.getString(2));
			//ִ����ɾ�����DML
//			int num = stat.executeUpdate("insert into a values(6,'bbb')");
			//����ֵΪӰ������
//			int num = stat.executeUpdate("update a set aname='zzz'");
//			System.out.println(num);
		} catch (ClassNotFoundException e) { //���Ҳ����쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
