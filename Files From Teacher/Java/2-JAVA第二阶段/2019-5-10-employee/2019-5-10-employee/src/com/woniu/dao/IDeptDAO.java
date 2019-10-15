package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Dept;

public interface IDeptDAO {
	void save(Dept dept);
	void update(Dept dept);
	void delete(Integer deptno);
	Dept findOne(Integer deptno);
	List<Dept> findAll();
}
