package com.woniuxy.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniuxy.domain.Dept;
import com.woniuxy.service.IDeptService;

public class AppTest {
	@Test
	public void test() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		// =====================================================
		s.beginTransaction();
		
		Dept d = new Dept();
		d.setDname("程序猿鼓励师");
		s.save(d);
		// =====================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	public void test2() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory) ctx.getBean("sf");
		Session s = sf.openSession();
		// =====================================================
		s.beginTransaction();
		
		Dept d = new Dept();
		d.setDname("程序猿鼓励师2");
		s.save(d);
		// =====================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	public void test3() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("applicationContext.xml");
		IDeptService service = (IDeptService) ctx.getBean("deptServiceImpl");
		
		System.out.println(service.getClass());
		
		Dept d = new Dept();
		Dept d2 = new Dept();
		d.setDname("开发部2");
		d2.setDname("测试部2");
		
		service.saveTwo(d, d2);
		
		
		
	}
}
