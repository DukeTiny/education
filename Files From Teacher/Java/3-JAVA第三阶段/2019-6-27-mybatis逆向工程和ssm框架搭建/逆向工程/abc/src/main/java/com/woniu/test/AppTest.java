package com.woniu.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.woniu.dao.DeptMapper;
import com.woniu.entity.Dept;
import com.woniu.entity.DeptExample;

public class AppTest {
	@Test
	public void test() throws Exception {
		InputStream in = AppTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession(true);
		// =======================================================
		
		DeptMapper mapper = s.getMapper(DeptMapper.class);
		
		DeptExample de = new DeptExample();
		de.or().andDidGreaterThanOrEqualTo(11);
		
		long count = mapper.countByExample(de);
		
		System.out.println(count);
		// =======================================================
		s.close();
		
	}
}
