package com.woniu.service;

import java.util.List;

import com.woniu.bean.User;

public interface IUserService {

	User getUserByUname(String uname);

	List<User> getAllUsers();

	User getUserByUid(int parseInt);

	void updateUser(User user);

	void addUser(User user);

}
