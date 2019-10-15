package com.woniuxy.l_lazyload;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ================================================
		
		DeptMapper mapper = s.getMapper(DeptMapper.class);
		
		Dept d = mapper.findOne(2);
		System.out.println(d.getDid() + " " +d.getDname());
//		System.out.println(d.getEmps());
		// ================================================
		s.close();
		
	}
	
	
	@Test
	public void testSave() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ================================================
		
		DeptMapper mapper = s.getMapper(DeptMapper.class);
		
		Dept d = new Dept();
		d.setDname("运维鼓励师部");
		
		mapper.save(d);
		
		
		// ================================================
		s.close();
		
	}
	
	
}
