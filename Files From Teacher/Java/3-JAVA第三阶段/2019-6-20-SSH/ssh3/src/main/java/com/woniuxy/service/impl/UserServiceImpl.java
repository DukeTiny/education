package com.woniuxy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.IUserDao;
import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;

@Service

public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	@Override
	@Transactional
	public void saveTwo(User user, User user2) {
		dao.save(user);
		System.out.println(8/2);
		dao.save(user2);
	}

	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void transfer(int from, int to, double money) {
		User user = dao.find(from);
		User user2 = dao.find(to);
		
		System.out.println(user);
		System.out.println(user2);
		System.out.println(money);
		
		user2.setMoney(user2.getMoney() + money);
		dao.update(user2);
		
		if(user.getMoney() < money) {
			throw new RuntimeException("Óà¶î²»×ã£º" + user.getMoney() + "£¬ ×ªÕË½ð¶î£º" + money);
		}
		
		user.setMoney(user.getMoney() - money);
		dao.update(user);
		
	}

}
