package com.cxz.service;

import com.cxz.dao.DAOFactory;
import com.cxz.po.UserLogin;

import java.util.List;

public class UserLoginServiceImpl implements IUserLoginService {


    public void add(UserLogin userLogin) {
        DAOFactory.getUserLoginDAOImpl().add(userLogin);
    }

    public void update(UserLogin userLogin,String pk_name) {
        DAOFactory.getUserLoginDAOImpl().update(userLogin,pk_name);
    }

    public void del(Integer id) {
        DAOFactory.getUserLoginDAOImpl().del(id);
    }

    public UserLogin getOne(Integer id) {
        return  DAOFactory.getUserLoginDAOImpl().getOne(id);
    }

    public List<UserLogin> getAll() {
        return  DAOFactory.getUserLoginDAOImpl().getAll();
    }
}