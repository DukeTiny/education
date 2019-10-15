package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Stu;
import com.woniu.util.BaseDAO;

public class StuDAOImpl implements IStuDAO {
	BaseDAO<Stu> bd = new BaseDAO<Stu>();
	@Override
	public void save(Stu stu) {
		String sql = "insert into stu values(null,?,?)";
		Object[] objs = {stu.getSname(),stu.getSphoto()};
		bd.update(sql, objs);
	}

	@Override
	public void update(Stu stu) {
		String sql = "update stu set sname=?,sphoto=? where sid=?";
		Object[] objs = {stu.getSname(),stu.getSphoto(),stu.getSid()};
		bd.update(sql, objs);
	}

	@Override
	public void delete(Integer sid) {
		String sql = "delete from stu where sid=?";
		Object[] objs = {sid};
		bd.update(sql, objs);

	}

	@Override
	public Stu findOne(Integer sid) {
		String sql = "select * from stu where sid=?";
		Object[] objs = {sid};
		List<Stu> stus = bd.select(sql, objs, Stu.class);
		return stus.size()==0?null:stus.get(0);
	}

	@Override
	public List<Stu> findAll() {
		String sql = "select * from stu";
		Object[] objs = {};
		List<Stu> stus = bd.select(sql, objs, Stu.class);
		return stus;
	}

}
