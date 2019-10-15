package com.woniuxy.service.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.dao.IDeptDao;
import com.woniuxy.domain.Dept;
import com.woniuxy.service.IDeptService;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private IDeptDao dao;
	
	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl.DeptServiceImpl()");
	}

	@Override
	public void saveTwo(Dept d, Dept d2) {
		dao.save(d);
		System.out.println(8/2);
		dao.save(d2);
	}

}
