package com.woniu.test;

import org.junit.Test;

import com.woniu.bean.Course;
import com.woniu.dao.CourseDAOImpl;
import com.woniu.dao.ICourseDAO;

public class TestCourse {
	ICourseDAO cd = new CourseDAOImpl();
	@Test
	public void test() {
		Course c = new Course();
		c.setCno("111");
		c.setCname("111");
		c.setTno("831");
		cd.save(c);
	}

}
