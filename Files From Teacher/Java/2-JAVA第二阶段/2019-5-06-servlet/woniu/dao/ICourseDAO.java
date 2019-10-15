package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Course;

public interface ICourseDAO {
	void save(Course course);
	void update(Course course);
	void delete(String cno);
	Course findOne(String cno);
	List<Course> findAll();
}
