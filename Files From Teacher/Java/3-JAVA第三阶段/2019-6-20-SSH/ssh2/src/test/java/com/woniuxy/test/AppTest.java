package com.woniuxy.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.RootConfig;
import com.woniuxy.domain.Dept;
import com.woniuxy.service.IDeptService;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new AnnotationConfigApplicationContext(RootConfig.class);
		
		IDeptService service = (IDeptService) ctx.getBean("deptServiceImpl");
		
		Dept d = new Dept();
		d.setDname("abc");
		Dept d2 = new Dept();
		d2.setDname("xyz");
		service.saveTwo(d, d2);
		
	}
}
