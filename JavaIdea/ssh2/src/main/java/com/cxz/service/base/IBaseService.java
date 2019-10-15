package com.cxz.service.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
    void save(T t);
    void update(T t);
    void delete(Serializable id);
    List<T> find();
    T find(Serializable id);
}
