package com.woniu.test;

import com.woniu.bean.User;
import com.woniu.dao.DAOFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User(1,"2","3",4);
		DAOFactory.getUserDAO().save(user);
	}

}
