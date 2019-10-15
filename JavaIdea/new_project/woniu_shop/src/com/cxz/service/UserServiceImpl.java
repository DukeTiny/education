package com.cxz.service;

import com.cxz.bean.UserInformation;
import com.cxz.dao.DAOFactory;

import java.util.List;

public class UserServiceImpl implements IUserService {
    @Override
    public void add(UserInformation user) {
        DAOFactory.getUserInfoDAO().add(user);
    }

    @Override
    public void update(UserInformation user) {
        DAOFactory.getUserInfoDAO().update(user);
    }

    @Override
    public void del(Integer userID) {
        DAOFactory.getUserInfoDAO().del(userID);
    }

    @Override
    public UserInformation findOne(Integer userID) {
        return DAOFactory.getUserInfoDAO().getOne(userID);
    }

    @Override
    public List<UserInformation> findALl() {
        return DAOFactory.getUserInfoDAO().getAll();
    }

    @Override
    public UserInformation findByNameAndPWD(String username, String password) {
        return DAOFactory.getUserInfoDAO().findByNameAndPWD(username,password);
    }
}
