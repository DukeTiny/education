package com.woniuxy.i_many2many;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ================================================
		StudentMapper mapper = s.getMapper(StudentMapper.class);
		List<Student> list = mapper.findAll();
		for (Student stu : list) {
			System.out.println(stu);
			System.out.println(stu.getTeachers());
		}
		// ================================================
		s.close();
		
	}
	
	
	@Test
	public void test2() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ================================================
		TeacherMapper mapper = s.getMapper(TeacherMapper.class);
		List<Teacher> list = mapper.findAll();
		for (Teacher t : list) {
			System.out.println(t);
			System.out.println(t.getStudents());
		}
		// ================================================
		s.close();
		
	}
}
