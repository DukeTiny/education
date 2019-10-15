package com.woniu.service;

import java.util.List;

import com.woniu.bean.PageBean;
import com.woniu.bean.User;
import com.woniu.dao.DAOFactory;

public class UserServiceImpl implements IUserService {

	@Override
	public void reg(User user) {
		user.setUrole("普通用户");
		user.setUstate("可用");
		DAOFactory.getUserDAO().save(user);
	}

	@Override
	public void addUser(User user) {
		DAOFactory.getUserDAO().save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return DAOFactory.getUserDAO().findAll();
	}

	@Override
	public List<User> getAllUsersByPage(PageBean pb) {
		List<User> users = DAOFactory.getUserDAO().findAll();
		pb.setCountRow(users.size());
		pb.setCountPage(users.size()%pb.getPageRow()==0?users.size()/pb.getPageRow():users.size()/pb.getPageRow()+1);
		List<User> usersByPage = DAOFactory.getUserDAO().findAllByPage(pb);
		return usersByPage;
	}

}
