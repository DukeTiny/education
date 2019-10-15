package com.woniu.test;

import org.junit.Test;

import com.woniu.jdbc.bean.Course;
import com.woniu.jdbc.dao.CourseDAOImpl;
import com.woniu.jdbc.dao.ICourseDAO;

public class TestCourse {

	ICourseDAO courseDAO = new CourseDAOImpl();
	@Test
	public void testSave() {
		Course course = new Course("3-106","MySql","825");
		courseDAO.save(course);
	}

}
