package com.woniu.test;

import org.junit.Test;

import com.woniu.bean.User;
import com.woniu.dao.DAOFactory;

public class TestUser {

	@Test
	public void test() {
		User u = new User();
		u.setUname("aaa");
		u.setUpwd("aaa");
		u.setUrole("普通用户");
		u.setUstate("可用");
		
		DAOFactory.getUserDAO().save(u);
	}

}
