package com.woniuxy.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

// BaseDaoImpl不需要被容器管理。
public class BaseDaoImpl<T> implements IBaseDao<T> {
	private Class clazz;
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass(); // BaseDaoImpl<Emp>
		ParameterizedType pt = (ParameterizedType) type;
		Type[] args = pt.getActualTypeArguments();
		clazz = (Class) args[0];
	}
	
	@Autowired
	private SessionFactory sf;
	
	private Session getSession() {
		return sf.getCurrentSession();
	}

	
	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void delete(Serializable id) {
		T t = (T) getSession().get(clazz, id);
		getSession().delete(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public T find(Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> find() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

	
}
