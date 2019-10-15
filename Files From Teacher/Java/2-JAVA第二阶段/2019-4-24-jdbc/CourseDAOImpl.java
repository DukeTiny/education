package com.woniu.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.woniu.jdbc.bean.Course;

public class CourseDAOImpl implements ICourseDAO {
	Connection conn;
	Statement stat;
	ResultSet rs;
	String url = "jdbc:mysql://localhost:3306/demo?characterEncoding=utf8";
	String user = "root";
	String password = "woniu";
	String driver = "com.mysql.jdbc.Driver";
	public void save(Course course) {
		try {
			//加载驱动
			Class.forName(driver);
			//建立连接
			conn = DriverManager.getConnection(url, user, password);
			//生成statement对象
			stat = conn.createStatement();
			//操作数据库
			String sql = "insert into course values('"+course.getCno()+"','"+course.getCname()+"','"+course.getTno()+"')";
			System.out.println(sql+"++++++++++++++++++++++");
			stat.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//关闭数据库
			 try {
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Course course) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stat = conn.createStatement();
			String sql = "UPDATE course SET cname='"+course.getCname()+"',tno='"+course.getTno()+"' WHERE cno='"+course.getCno()+"'";
			stat.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	@Override
	public void delete(String cno) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stat = conn.createStatement();
			String sql = "DELETE FROM course WHERE cno='"+cno+"'";
			stat.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public Course findOne(String cno) {
		Course course = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stat = conn.createStatement();
			String sql = "select * FROM course WHERE cno='"+cno+"'";
			rs = stat.executeQuery(sql);
			if(rs.next()){
				course = new Course();
				course.setCno(rs.getString(1));
				course.setCname(rs.getString(2));
				course.setTno(rs.getString(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return course;
	}

	@Override
	public List<Course> findAll() {
		List<Course> courses = new ArrayList<Course>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stat = conn.createStatement();
			String sql = "select * FROM course";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				Course course = new Course();
				course.setCno(rs.getString(1));
				course.setCname(rs.getString(2));
				course.setTno(rs.getString(3));
				courses.add(course);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courses;
	}

}
