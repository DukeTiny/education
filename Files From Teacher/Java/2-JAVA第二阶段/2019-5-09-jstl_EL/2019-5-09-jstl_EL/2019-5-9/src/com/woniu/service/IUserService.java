package com.woniu.service;

import java.util.List;

import com.woniu.bean.PageBean;
import com.woniu.bean.User;

public interface IUserService {
	void reg(User user);
	void addUser(User user);
	List<User> getAllUsers();
	List<User> getAllUsersByPage(PageBean pb);
}
