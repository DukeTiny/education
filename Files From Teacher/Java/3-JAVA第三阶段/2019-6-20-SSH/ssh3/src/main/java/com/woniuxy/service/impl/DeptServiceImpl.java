package com.woniuxy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

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
	
	@Override
	public void save(Dept dept) {
		dao.save(dept);
	}

	@Override
	public void delete(Integer did) {
		dao.delete(did);
	}

	@Override
	public void update(Dept dept) {
		dao.update(dept);
	}

	@Override
	public Dept find(Integer did) {
		return dao.find(did);
	}

	@Override
	public List<Dept> find() {
		return dao.find();
	}

}
