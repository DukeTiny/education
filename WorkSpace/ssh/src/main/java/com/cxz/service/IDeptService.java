package com.cxz.service;

import java.io.Serializable;
import java.util.List;

import com.cxz.domain.Dept;

public interface IDeptService {
	 void save(Dept dept);
    void update(Dept dept);
    void delete(Serializable id);
    List<Dept> find();
    Dept find(Serializable id);
}
