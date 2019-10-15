package com.woniu.dao;

import java.util.List;

import com.woniu.bean.User;

public interface IUserDAO {
	void save(User user);
	void update(User user);
	void delete(Integer uid);
	User findOne(Integer uid);
	List<User> findAll();
}
