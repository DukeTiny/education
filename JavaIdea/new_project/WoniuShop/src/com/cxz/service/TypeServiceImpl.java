package com.cxz.service;

import com.cxz.dao.DAOFactory;
import com.cxz.po.Type;

import java.util.List;

public class TypeServiceImpl implements ITypeService {


    public void add(Type type) {
        DAOFactory.getTypeDAOImpl().add(type);
    }

    public void update(Type type,String pk_name) {
        DAOFactory.getTypeDAOImpl().update(type,pk_name);
    }

    public void del(Integer id) {
        DAOFactory.getTypeDAOImpl().del(id);
    }

    public Type getOne(Integer id) {
        return  DAOFactory.getTypeDAOImpl().getOne(id);
    }

    public List<Type> getAll() {
        return  DAOFactory.getTypeDAOImpl().getAll();
    }

}