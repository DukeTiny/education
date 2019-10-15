package com.cxz.review;

import java.util.List;

public class UserDaoImpl implements IUserDao {

	public void save(User user) {
		System.out.println("UserDaoImpk.save()");
	}

	public void update(User user) {
		System.out.println("UserDaoImpk.update()");
	}

	public void delete(Integer id) {
		System.out.println("UserDaoImpk.delete()");
	}

	public User find(Integer id) {
		System.out.println("UserDaoImpk.find()");
		return null;
	}

	public List<User> find() {
		System.out.println("UserDaoImpk.find()");
		return null;
	}

}
