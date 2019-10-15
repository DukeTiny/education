package com.woniu.dao;

import java.util.List;

import com.woniu.bean.User;
import com.woniu.util.BaseDAO;

public class UserDAOImpl implements IUserDAO {
	BaseDAO<User> bd = new BaseDAO<User>();
	
	@Override
	public void save(User user) {
		String sql = "INSERT INTO t_user VALUES(NULL,?,?,?)";
		Object[] objs = {user.getUname(),user.getUpwd(),user.getUrole()};
		bd.update(sql, objs);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE t_user SET uname=?,upwd=?,urole=? WHERE uid=?";
		Object[] objs = {user.getUname(),user.getUpwd(),user.getUrole(),user.getUid()};
		bd.update(sql, objs);
	}
	
	@Override
	public void delete(Integer uid) {
		String sql = "DELETE FROM t_user WHERE uid=?";
		Object[] objs = {uid};
		bd.update(sql, objs);

	}

	@Override
	public User findOne(Integer uid) {
		String sql = "select * from t_user where uid=?";
		Object[] objs = {uid};
		List<User> users = bd.select(sql, objs, User.class);
		return users.size()==0?null:users.get(0);
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from t_user";
		Object[] objs = {};
		List<User> users = bd.select(sql, objs, User.class);
		return users;
	}

	@Override
	public User login(String uname, String upwd) {
		String sql = "select * from t_user where uname=? and upwd=?";
		Object[] objs = {uname,upwd};
		List<User> users = bd.select(sql, objs, User.class);
		return users.size()==0?null:users.get(0);
	}

}
