package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Emp;

public interface IEmpService {
	void save(Emp e);
	void delete(Integer eid);
	void update(Emp e);
	Emp find(Integer eid);
	List<Emp> find();
}
