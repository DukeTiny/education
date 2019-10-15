package com.woniuxy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniuxy.web.servlet.UserServlet;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserServlet us = (UserServlet) ctx.getBean("userServlet");
		System.out.println(us);
		System.out.println(us.service);
		
	}
}
