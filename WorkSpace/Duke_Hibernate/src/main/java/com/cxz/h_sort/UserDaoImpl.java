package com.cxz.h_sort;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDaoImpl implements IUserDao {

	public void save(User user) {
		Session s = HibernateUtils.getSession();
		s.save(user);
	}

	public void update(User user) {
		Session s = HibernateUtils.getSession();
		s.update(user);
	}

	public void delete(Integer id) {
		Session s = HibernateUtils.getSession();
		User user = s.get(User.class,id);
		s.delete(user);
	}

	public User find(Integer id) {
		Session s = HibernateUtils.getSession();
		User user = (User)s.get(User.class,id);
		return user;
	}

	public List<User> find() {
		Session s = HibernateUtils.getSession();
		String hql = "From User";
		Query<User> q = s.createQuery(hql);
		List<User> list = q.list();
		return list;
	}
	public void free(Session s) {
		HibernateUtils.free(s);
	}

}
