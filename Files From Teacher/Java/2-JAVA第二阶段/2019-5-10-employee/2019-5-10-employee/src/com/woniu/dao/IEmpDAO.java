package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Emp;

public interface IEmpDAO {
	void save(Emp emp);
	void update(Emp emp);
	void delete(Integer empno);
	Emp findOne(Integer empno);
	List<Emp> findAll();
}
