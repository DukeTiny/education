package com.cxz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxz.dao.IUserDao;
import com.cxz.domain.User;
import com.cxz.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}

}
