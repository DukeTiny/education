package com.cxz.test;
import com.cxz.service.IDeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.domain.Dept;

public class AppTest {

	@Test
	public void testName() throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IDeptService service = (IDeptService) ctx.getBean("deptServiceImpl");
        Dept d1 = new Dept();
        Dept d2 = new Dept();
        d1.setDname("Design@@");
        d2.setDname("Sale@@");
        service.saveDouble(d1, d2);
	}
}
