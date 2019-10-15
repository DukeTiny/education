package com.cxz.dao.impl;

import org.springframework.stereotype.Repository;

import com.cxz.dao.IUserDao;
import com.cxz.domain.User;

@Repository
public class UserDaoImpl implements IUserDao {

	public void save(User user) {
		System.out.println("UserDaoImpl.save()~~~~~~~~~~~~~");
	}

}
