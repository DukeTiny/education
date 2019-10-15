package com.woniuxy.j_dynamicsql;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		
		UserExample ue = new UserExample();
//		 ue.setId(1);
//		 ue.setName("haha");
		// ue.setMoney(1000);
//		ue.setIds(Arrays.asList(1,2,3,5));
		List<User> list = mapper.find3(ue);
		
		for (User user : list) {
			System.out.println(user);
			
		}
		
		// ======================================================
		s.close();
	}
	
	
	@Test
	public void test2() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		UserMapper mapper = s.getMapper(UserMapper.class);
		
		User user = new User();
		user.setId(12);
		user.setName("³ÉÁú");
//		user.setBirthday(new Date());
//		user.setMoney(1112d);
		mapper.update2(user);
		
		// ======================================================
		s.close();
	}
	
	
}
