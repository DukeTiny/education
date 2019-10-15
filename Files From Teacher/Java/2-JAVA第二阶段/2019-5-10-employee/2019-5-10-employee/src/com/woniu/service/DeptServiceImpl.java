package com.woniu.service;

import java.util.List;

import com.woniu.bean.Dept;
import com.woniu.dao.DAOFactory;

public class DeptServiceImpl implements IDeptService {

	@Override
	public void addDept(Dept dept) {
		DAOFactory.getDeptDAO().save(dept);

	}

	@Override
	public void editDept(Dept dept) {
		// TODO Auto-generated method stub
		DAOFactory.getDeptDAO().update(dept);
	}

	@Override
	public void delDept(Integer deptno) {
		// TODO Auto-generated method stub
		DAOFactory.getDeptDAO().delete(deptno);
	}

	@Override
	public Dept getDept(Integer deptno) {
		// TODO Auto-generated method stub
		return DAOFactory.getDeptDAO().findOne(deptno);
	}

	@Override
	public List<Dept> getAllDept() {
		// TODO Auto-generated method stub
		return DAOFactory.getDeptDAO().findAll();
	}

}
