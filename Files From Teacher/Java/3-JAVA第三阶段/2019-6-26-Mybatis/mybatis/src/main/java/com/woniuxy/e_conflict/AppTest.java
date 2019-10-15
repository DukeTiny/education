package com.woniuxy.e_conflict;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		
		UserMapper mapper = s.getMapper(UserMapper.class);
		
		List<User> list = mapper.findAll2();
		
		for (User user : list) {
			System.out.println(user);
		}
		
//		Map map = new HashMap();
//		map.put("startLine", 3);
//		map.put("size",5);
//		List<User> list = mapper.findSome(map);
//		
//		for (User user : list) {
//			System.out.println(user);
//			
//		}
		
		// ======================================================
		s.close();
	}
	
	
}
