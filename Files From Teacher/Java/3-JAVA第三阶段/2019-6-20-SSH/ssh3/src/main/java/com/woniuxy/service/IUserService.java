package com.woniuxy.service;

import com.woniuxy.domain.User;

public interface IUserService {
	void saveTwo(User user, User user2);
	void transfer(int from, int to, double money);
}
