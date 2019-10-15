package com.cxz.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.sql.ast.statement.SQLWithSubqueryClause.Entry;
import com.cxz.dao.IDeptDao;
import com.cxz.domain.Dept;
import com.cxz.service.IDeptService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest {

	@Autowired
	private IDeptService service;
	
	@Test
	public void testService() throws Exception {
		
		
		Dept d1 = new Dept();
		Dept d2 = new Dept();
		d1.setDname("Design~");
		d2.setDname("Sale~");
		
		service.save(d1);
		service.save(d2);
		
	}
	
}
