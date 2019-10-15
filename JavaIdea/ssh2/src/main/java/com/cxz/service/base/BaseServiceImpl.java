package com.cxz.service.base;

import com.cxz.dao.base.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


public class BaseServiceImpl<T> implements IBaseService<T>{

    @Autowired
    private IBaseDao<T> baseDao;

    @Override
    public void save(T t) {
        baseDao.save(t);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public void delete(Serializable id) {
        baseDao.delete(id);
    }

    @Override
    public List<T> find() {
        return baseDao.find();
    }

    @Override
    public T find(Serializable id) {
        return baseDao.find(id);
    }
}
