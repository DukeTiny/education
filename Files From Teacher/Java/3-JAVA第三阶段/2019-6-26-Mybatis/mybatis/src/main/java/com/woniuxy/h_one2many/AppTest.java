package com.woniuxy.h_one2many;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ================================================
		
		DeptMapper mapper = s.getMapper(DeptMapper.class);
		
		Dept d = mapper.findOne(1);
		System.out.println(d);
		System.out.println(d.getEmps());
		
		// ================================================
		s.close();
		
	}
	
	
	@Test
	public void test2() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ================================================
		EmpMapper mapper = s.getMapper(EmpMapper.class);
		Emp e = mapper.findOne(4);
		System.out.println(e);
		System.out.println(e.getDept());
		// ================================================
		s.close();
		
	}
}
