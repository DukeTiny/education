package com.cxz.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
    void save(T t);
    void update(T t);
    void delete(Serializable id);
    List<T> find();
    T find(Serializable id);
}
