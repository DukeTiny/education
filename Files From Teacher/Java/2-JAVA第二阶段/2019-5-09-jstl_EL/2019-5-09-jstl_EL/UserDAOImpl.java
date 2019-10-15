package com.woniu.dao;

import java.util.List;

import com.woniu.bean.PageBean;
import com.woniu.bean.User;
import com.woniu.util.BaseDAO;

public class UserDAOImpl implements IUserDAO {
	BaseDAO<User> bd =new BaseDAO<User>();
	@Override
	public void save(User user) {
		String sql = "insert into t_user values(null,?,?,?,?)";
		Object[] objs = {user.getUname(),user.getUpwd(),user.getUrole(),user.getUstate()};
		bd.update(sql, objs);
	}

	@Override
	public void update(User user) {
		String sql = "update t_user set uname=?,upwd=?,urole=?,ustate=? where uid=?";
		Object[] objs = {user.getUname(),user.getUpwd(),user.getUrole(),user.getUstate(),user.getUid()};
		bd.update(sql, objs);
	}

	@Override
	public void delete(Integer uid) {
		String sql = "delete from t_user where uid=?";
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
	public User login(User user) {
		String sql = "select * from t_user where uname=? and upwd=?";
		Object[] objs = {user.getUname(),user.getUpwd()};
		List<User> users = bd.select(sql, objs, User.class);
		return users.size()==0?null:users.get(0);
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from t_user";
		System.out.println("in findAll...");
		Object[] objs = {};
		List<User> users = bd.select(sql, objs, User.class);
		return users;
	}

	@Override
	public List<User> findAllByPage(PageBean pb) {
		String sql = "select * from t_user limit ?,?";
		System.out.println("in findAll...");
		Object[] objs = {(pb.getPageNum()-1)*pb.getPageRow(),pb.getPageRow()};
		List<User> users = bd.select(sql, objs, User.class);
		return users;
	}

}
