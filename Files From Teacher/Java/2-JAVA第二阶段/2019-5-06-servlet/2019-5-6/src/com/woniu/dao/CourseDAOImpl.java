package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Course;
import com.woniu.util.BaseDAO;

public class CourseDAOImpl implements ICourseDAO {
	BaseDAO<Course> bd = new BaseDAO<Course>();
	@Override
	public void save(Course course) {
		String sql = "insert into course values(?,?,?)";
		Object[] objs = {course.getCno(),course.getCname(),course.getTno()};
		bd.update(sql, objs);
	}

	@Override
	public void update(Course course) {
		String sql = "update course set cname=?,tno=? where cno=?";
		Object[] objs = {course.getCname(),course.getTno(),course.getCno()};
		bd.update(sql, objs);

	}

	@Override
	public void delete(String cno) {
		String sql = "delete from course where cno=?";
		Object[] objs = {cno};
		bd.update(sql, objs);
	}

	@Override
	public Course findOne(String cno) {
		String sql = "select * from course where cno=?";
		Object[] objs = {cno};
		List<Course> list = bd.select(sql, objs, Course.class);
		return list.size()!=0?list.get(0):null;
	}

	@Override
	public List<Course> findAll() {
		String sql = "select * from course";
		Object[] objs = {};
		List<Course> courses = bd.select(sql, objs, Course.class);
		return courses;
	}

}
