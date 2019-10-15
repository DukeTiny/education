package com.woniu.jdbc.dao;

import java.util.List;

import com.woniu.jdbc.bean.Course;

public interface ICourseDAO {
	void save(Course course);
	void update(Course course);
	void delete(int cno);
	Course findOne(int cno);
	List<Course> findAll();
}
