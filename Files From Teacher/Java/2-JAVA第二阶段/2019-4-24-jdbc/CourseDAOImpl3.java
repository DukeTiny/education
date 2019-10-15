package com.woniu.jdbc.dao;

import java.util.List;

import com.woniu.jdbc.bean.Course;

public class CourseDAOImpl3 implements ICourseDAO {

	@Override
	public void save(Course course) {
		String sql = "insert into course values(?,?,?)";
		Object[] objs = {course.getCno(),course.getCname(),course.getTno()};
		BaseDAO.update(sql,objs);
	}

	@Override
	public void update(Course course) {
		String sql = "update course set cname=?,tno=? where cno=?";
		Object[] objs = {course.getCname(),course.getTno(),course.getCno()};
		BaseDAO.update(sql,objs);
	}

	@Override
	public void delete(String cno) {
		String sql = "delete from course where cno=?";
		Object[] objs = {cno};
		BaseDAO.update(sql,objs);
	}

	@Override
	public Course findOne(String cno) {
		String sql = "select * from course where cno=?";
		Object[] objs = {cno};
		return BaseDAO.select(sql, objs).get(0);
	}

	@Override
	public List<Course> findAll() {
		String sql = "select * from course";
		Object[] objs = {};
		return BaseDAO.select(sql, objs);
	}

}
