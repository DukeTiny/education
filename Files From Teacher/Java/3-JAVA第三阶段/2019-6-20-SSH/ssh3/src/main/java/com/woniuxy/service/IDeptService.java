package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Dept;

public interface IDeptService {
	void save(Dept dept);
	void delete(Integer did);
	void update(Dept dept);
	Dept find(Integer did);
	List<Dept> find();
}
