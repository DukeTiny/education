package com.woniuxy.service.impl;

import org.springframework.stereotype.Service;

import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl()");
	}
	
	@Override
	public void save(User user) {
		System.out.println("save user to db...");
	}
}
