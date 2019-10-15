package com.cxz.test;
import com.cxz.RootConfig;
import com.cxz.dao.IDeptDao;
import com.cxz.dao.IEmpDao;
import com.cxz.domain.Emp;
import com.cxz.service.IDeptService;
import com.cxz.service.IEmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.domain.Dept;

public class AppTest {

	@Test
	public void testName() throws Exception {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);
		IDeptDao deptService = (IDeptDao) ctx.getBean("deptDaoImpl");
        Dept d1 = new Dept();
        Dept d2 = new Dept();
        d1.setDname("Design@@");
        d2.setDname("Sale@@");
        deptService.save(d1);
        deptService.save(d2);
//		IEmpDao empService = (IEmpDao) ctx.getBean("empDaoImpl");
//
//		Emp e = new Emp();
//		e.setEname("LiFei");
//        empService.save(e);
	}
}
