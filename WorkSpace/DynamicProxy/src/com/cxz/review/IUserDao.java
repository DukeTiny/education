package com.cxz.review;

import java.util.List;

public interface IUserDao {
	
	void save(User user);
	void update(User user);
	void delete(Integer id);
	User find(Integer id);
	List<User> find();
	
}
