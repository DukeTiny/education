package com.sia.service;

import com.sia.bean.User;
import com.sia.dao.DaoFactory;

import java.util.List;

public class UserServiceImpl implements IUserService{

    @Override
    public void add(User user) {
        DaoFactory.getUserDAO().add(user);
    }

    @Override
    public void update(User user) {
        DaoFactory.getUserDAO().update(user);
    }

    @Override
    public void del(Integer uid) {
        DaoFactory.getUserDAO().del(uid);
    }

    @Override
    public User getOne(Integer uid) {
        return DaoFactory.getUserDAO().getOne(uid);
    }

    @Override
    public User getOneByName(String uname) {
        return DaoFactory.getUserDAO().getOneByName(uname);
    }

    @Override
    public List<User> getAll() {
        return DaoFactory.getUserDAO().getAll();
    }
}
