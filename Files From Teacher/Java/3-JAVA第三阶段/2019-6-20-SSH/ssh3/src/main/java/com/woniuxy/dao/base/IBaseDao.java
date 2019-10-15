package com.woniuxy.dao.base;

import java.io.Serializable;
import java.util.List;

// T ���Ͳ���
// IBaseDao<T>  ����������
// ���������֡��ڿӡ����
public interface IBaseDao<T> {
	void save(T t);
	void delete(Serializable id); 
	void update(T t);
	T find(Serializable id);
	List<T> find();
}
