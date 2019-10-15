package com.woniuxy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woniuxy.domain.Dept;
import com.woniuxy.service.IDeptService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest {
	@Autowired
	private IDeptService service;
	@Test
	public void test() throws Exception {
		Dept d = new Dept();
		d.setDname("xxxx");
		service.save(d);
	}
}