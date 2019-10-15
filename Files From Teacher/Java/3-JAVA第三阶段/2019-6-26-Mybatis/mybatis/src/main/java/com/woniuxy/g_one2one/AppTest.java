package com.woniuxy.g_one2one;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ================================================
		
		HusbandMapper mapper = s.getMapper(HusbandMapper.class);
		
		Husband h = mapper.findOne(2);
		
		System.out.println(h);
		System.out.println(h.getWife());
		
		// ================================================
		s.close();
		
	}
	
	
	@Test
	public void test2() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ================================================
		
		WifeMapper mapper = s.getMapper(WifeMapper.class);
		Wife w = mapper.findOne(1);
		System.out.println(w);
		System.out.println(w.getHusband());
		
		// ================================================
		s.close();
		
	}
}
