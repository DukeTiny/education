package com.cxz.service;

import com.cxz.po.Type;

import java.util.List;

public interface ITypeService {
 
   void add(Type type);

    void update(Type type,String pk_name);

    void del(Integer id);

    Type getOne(Integer id);

    List<Type> getAll();
}