package com.woniu.service;

import java.util.List;

import com.woniu.bean.Stu;
import com.woniu.dao.DAOFactory;

public class StuServiceImpl implements IStuService {

	@Override
	public void addStu(Stu stu) {
		// TODO Auto-generated method stub
		DAOFactory.getStuDAO().save(stu);
	}

	@Override
	public List<Stu> getAllStus() {
		// TODO Auto-generated method stub
		return DAOFactory.getStuDAO().findAll();
	}

	@Override
	public void delStu(int sid) {
		DAOFactory.getStuDAO().delete(sid);
	}

	@Override
	public Stu getStuBySid(int sid) {
		// TODO Auto-generated method stub
		return DAOFactory.getStuDAO().findOne(sid);
	}

	@Override
	public void editStu(Stu stu) {
		DAOFactory.getStuDAO().update(stu);
		
	}


}
