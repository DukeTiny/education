package com.woniuxy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.dao.IEmpDao;
import com.woniuxy.domain.Emp;
import com.woniuxy.service.IEmpService;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService {

	@Autowired
	private IEmpDao dao;
	
	@Override
	public void save(Emp e) {
		dao.save(e);
	}

	@Override
	public void delete(Integer eid) {
		dao.delete(eid);
	}

	@Override
	public void update(Emp e) {
		dao.update(e);
	}

	@Override
	public Emp find(Integer eid) {
		return dao.find(eid);
	}

	@Override
	public List<Emp> find() {
		return dao.find();
	}

}