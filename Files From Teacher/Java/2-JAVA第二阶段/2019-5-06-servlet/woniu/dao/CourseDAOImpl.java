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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String cno) {
		// TODO Auto-generated method stub

	}

	@Override
	public Course findOne(String cno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
