package com.woniu.service;

import java.util.List;

import com.woniu.bean.User;
import com.woniu.dao.DAOFactory;

public class UserServiceImpl implements IUserService {

	@Override
	public User getUserByUname(String uname) {
		List<User> users = DAOFactory.getUserDAO().findAll();
		User u = null;
		for(User user:users){
			if(user.getUname().equals(uname)){
				u = user;
			}
		}
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return DAOFactory.getUserDAO().findAll();
	}

	@Override
	public User getUserByUid(int uid) {
		// TODO Auto-generated method stub
		return DAOFactory.getUserDAO().findOne(uid);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		DAOFactory.getUserDAO().update(user);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		DAOFactory.getUserDAO().save(user);
	}

}
