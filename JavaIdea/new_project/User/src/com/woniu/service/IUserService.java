package com.woniu.service;

import java.util.List;

import com.woniu.bean.User;

public interface IUserService {
	void addUser(User user);
	void editUser(User user);
	void delUser(Integer uid);
	User findOne(Integer uid);
	List<User> findAll();
	
	
}
