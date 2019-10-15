package com.cxz.service;

import java.util.List;

import com.cxz.model.User;

public interface IUserService {

	public User login(User user);
	public void save(User user,Integer[] rids);
	public void delete(Integer id);
	public List<User> findAll();
	public void update(User user,Integer[] rids);
	public User findById(Integer id);
	
}
