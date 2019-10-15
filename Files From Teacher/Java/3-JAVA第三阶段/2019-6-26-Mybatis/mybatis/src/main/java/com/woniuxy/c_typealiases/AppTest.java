package com.woniuxy.c_typealiases;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		User user = new User();
		user.setName("’≈∞ÿ÷•");
		user.setBirthday(new Date());
		user.setMoney(1111d);
		s.insert("com.woniuxy.c_typealiases.UserMapper.save", user);
		// ======================================================
		s.close();
	}
	
	
}
