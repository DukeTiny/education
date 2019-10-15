package com.cxz.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> implements IBaseDao<T>{

    private Class clazz;
    public BaseDaoImpl() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)type;
        Type[] args = pt.getActualTypeArguments();
        clazz = (Class)args[0];
    }

    @Autowired
    private SessionFactory sf;

    private Session getSession(){
        return sf.getCurrentSession();
    }

    @Override
    public void save(T t) {
        getSession().save(t);
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public void delete(Serializable id) {
        T t = (T)getSession().find(clazz,id);
        getSession().delete(t);
    }

    @Override
    public List<T> find() {
        return getSession().createQuery("From " + clazz.getSimpleName()).list();
    }

    @Override
    public T find(Serializable id) {
        return (T)getSession().find(clazz,id);
    }
}
