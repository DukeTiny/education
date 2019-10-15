package com.cxz.h_sort;

import java.util.List;

public interface IUserDao {

	void save(User user);
	void update(User user);
	void delete(Integer id);
	User find(Integer id);
	List<User> find();
	
}
