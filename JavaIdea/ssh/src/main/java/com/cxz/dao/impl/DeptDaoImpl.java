package com.cxz.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cxz.dao.IDeptDao;
import com.cxz.domain.Dept;


@Repository
public class DeptDaoImpl implements IDeptDao {

	@Autowired
	private SessionFactory sf;
	
	private Session getSession() {
		return sf.getCurrentSession();
	}
	
	public void save(Dept dept) {
		getSession().save(dept);
    }

}
