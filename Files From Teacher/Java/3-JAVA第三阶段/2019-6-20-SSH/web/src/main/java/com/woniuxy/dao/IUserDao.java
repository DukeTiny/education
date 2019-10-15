package com.woniuxy.dao;

import java.sql.Connection;

import com.woniuxy.domain.User;

public interface IUserDao {
	User find(Integer id);
	void update(User user);
}
