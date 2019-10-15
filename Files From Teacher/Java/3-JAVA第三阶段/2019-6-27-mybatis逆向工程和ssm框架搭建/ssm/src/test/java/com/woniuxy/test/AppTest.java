package com.woniuxy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniuxy.entity.User;
import com.woniuxy.service.IUserService;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IUserService service =  (IUserService) ctx.getBean("userServiceImpl");

		User user = new User();
		user.setName("xxqq");
		
		service.save(user);
	}
}
