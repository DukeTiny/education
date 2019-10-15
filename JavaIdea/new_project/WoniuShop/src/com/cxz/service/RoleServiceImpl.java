package com.cxz.service;

import com.cxz.dao.DAOFactory;
import com.cxz.po.Role;

import java.util.List;

public class RoleServiceImpl implements IRoleService {


    public void add(Role role) {
        DAOFactory.getRoleDAOImpl().add(role);
    }

    public void update(Role role,String pk_name) {
        DAOFactory.getRoleDAOImpl().update(role,pk_name);
    }

    public void del(Integer id) {
        DAOFactory.getRoleDAOImpl().del(id);
    }

    public Role getOne(Integer id) {
        return  DAOFactory.getRoleDAOImpl().getOne(id);
    }

    public List<Role> getAll() {
        return  DAOFactory.getRoleDAOImpl().getAll();
    }
}