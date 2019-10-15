package com.woniuxy.f_$;

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
//		User user = new User();
//		user.setName("уелЗаж");
//		user.setBirthday(new Date());
//		user.setMoney(1234d);
//		mapper.save(user);
		
		Map map = new HashMap();
		map.put("column", "money");
		
		
		List<User> list = mapper.findAllByColumnDesc(map);
		for (User user : list) {
			System.out.println(user);
			
		}
		
		
		
		
		// ======================================================
		s.close();
	}
	
	
}
