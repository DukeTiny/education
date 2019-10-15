package com.woniuxy.dao.base;

import java.io.Serializable;
import java.util.List;

// T 类型参数
// IBaseDao<T>  参数化类型
// 给坑起名字、挖坑、填坑
public interface IBaseDao<T> {
	void save(T t);
	void delete(Serializable id); 
	void update(T t);
	T find(Serializable id);
	List<T> find();
}
