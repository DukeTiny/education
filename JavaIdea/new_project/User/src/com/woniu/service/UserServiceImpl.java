package com.woniu.service;

import java.util.List;

import com.woniu.bean.User;
import com.woniu.dao.DAOFactory;

public class UserServiceImpl implements IUserService {

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		DAOFactory.getUserDAO().save(user);
	}

	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub
		DAOFactory.getUserDAO().update(user);
	}

	@Override
	public void delUser(Integer uid) {
		// TODO Auto-generated method stub
		DAOFactory.getUserDAO().delete(uid);
	}

	@Override
	public User findOne(Integer uid) {
		// TODO Auto-generated method stub
		return DAOFactory.getUserDAO().findOne(uid);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return DAOFactory.getUserDAO().findAll();
	}

	
}
