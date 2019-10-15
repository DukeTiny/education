package com.woniuxy.d_dao;

import java.util.Date;
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
		User user = new User();
		user.setId(22);
		user.setName("张曼玉");
		user.setBirthday(new Date());
		user.setMoney(1111d);
		
		UserMapper mapper = s.getMapper(UserMapper.class);
		
		// 当我们调用代理对象mapper的save方法时，mybatis会自动在与接口类型同名的配置文件中，找id为"save"sql语句
//		mapper.save(user);
//		mapper.delete(23); 
//		mapper.update(user);
		
//		User u = mapper.findOne(16);
//		System.out.println(u);
		
//		List<User> list = mapper.findAll();
//		for (User u : list) {
//			System.out.println(u);
//		}
		
//		Map map = new HashMap();
//		map.put("min", 300d);
//		map.put("max", 800d);
//		List<User> list = mapper.findSomeByMoneyRange(map);
//		
//		for (User u : list) {
//			System.out.println(u);
//		}
		
		User u = mapper.findByName("梅超风");
		System.out.println(u);
		
		// ======================================================
		s.close();
	}
	
	
}
