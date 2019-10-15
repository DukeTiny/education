package com.woniu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.woniu.jdbc.bean.Course;
import com.woniu.util.JdbcUtils;

public class CourseDAOImpl2 implements ICourseDAO {
	Connection conn;
	PreparedStatement stat;
	ResultSet rs;
	public void save(Course course) {
		String sql = "insert into course values(?,?,?)";
		
	}

	public void update(Course course) {
		String sql = "update course set cname=?,tno=? where cno=?";
		try {
			conn = JdbcUtils.getConn();
			stat = conn.prepareStatement(sql);
			stat.setString(3, course.getCno());
			stat.setString(1, course.getCname());
			stat.setString(2, course.getTno());
			stat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.closeConn(null, stat, conn);
		}

	}

	public void delete(String cno) {
		String sql = "delete from course where cno=?";
		try {
			conn = JdbcUtils.getConn();
			stat = conn.prepareStatement(sql);
			stat.setString(1, cno);
			stat.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.closeConn(null, stat, conn);
		}

	}

	public Course findOne(String cno) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
