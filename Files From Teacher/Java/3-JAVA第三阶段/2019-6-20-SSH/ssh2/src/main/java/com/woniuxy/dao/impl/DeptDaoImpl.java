package com.woniuxy.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniuxy.dao.IDeptDao;
import com.woniuxy.domain.Dept;

@Repository
public class DeptDaoImpl implements IDeptDao {

	@Autowired
	private SessionFactory sf;
	
	private Session getSession() {
		return sf.getCurrentSession();
	}
	
	@Override
	public void save(Dept d) {
		getSession().save(d);
	}

}
