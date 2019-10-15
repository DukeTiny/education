package com.woniu.dao;

import java.util.List;

import com.woniu.bean.PageBean;
import com.woniu.bean.User;

public interface IUserDAO {
	void save(User user);
	void update(User user);
	void delete(Integer uid);
	User findOne(Integer uid);
	User login(User user);
	List<User> findAll();
	List<User> findAllByPage(PageBean pb);
}
