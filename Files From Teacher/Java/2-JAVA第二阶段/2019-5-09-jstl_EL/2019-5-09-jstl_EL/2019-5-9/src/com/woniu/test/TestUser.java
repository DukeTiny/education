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
		u.setUrole("��ͨ�û�");
		u.setUstate("����");
		
		DAOFactory.getUserDAO().save(u);
	}

}
