package com.cxz.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxz.dao.IDeptDao;
import com.cxz.domain.Dept;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

	
	@Autowired
	private IDeptDao dao;
	
	public void save(Dept dept) {

	}

	@Override
	public void update(Dept dept) {

	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Dept> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dept find(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
