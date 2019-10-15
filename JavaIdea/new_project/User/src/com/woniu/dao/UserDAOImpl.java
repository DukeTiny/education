package com.woniu.dao;

import java.util.List;

import com.woniu.bean.User;
import com.woniu.util.BaseDAO;

public class UserDAOImpl implements IUserDAO {
    BaseDAO<User> bd = new BaseDAO<User>();
	@Override
	public void save(User user) {
		String sql = "insert into `user` values(?,?,?,?)";
		Object[] obj = {user.getUid(),user.getUname(),user.getSex(),user.getAge()};
		bd.update(sql, obj);
	}

	@Override
	public void update(User user) {
		String sql = "update user set uname=?,sex=?,age=? where uid=?";
		Object[] obj = {user.getUname(),user.getSex(),user.getAge(),user.getUid()};
		bd.update(sql, obj);
		
	}

	@Override
	public void delete(Integer uid) {
		String sql = "delete from user where uid=?";
		Object[] obj = {uid};
		bd.update(sql, obj);
		
	}

	@Override
	public User findOne(Integer uid) {
		String sql = "select * from user where uid=?";
		Object[] objs = {uid};
		List<User> u = bd.select(sql, objs, User.class);
		return u.size()==0?null:u.get(0);
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		Object[] objs = {};
		List<User> u = bd.select(sql, objs, User.class);
		return u;
	}

}
