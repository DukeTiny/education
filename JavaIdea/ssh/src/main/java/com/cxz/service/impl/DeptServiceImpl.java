package com.cxz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxz.dao.IDeptDao;
import com.cxz.domain.Dept;
import com.cxz.service.IDeptService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private IDeptDao deptDao;
	public void saveDouble(Dept d1, Dept d2) {
		deptDao.save(d1);
		System.out.println(2/0);
		deptDao.save(d2);
	}

}
