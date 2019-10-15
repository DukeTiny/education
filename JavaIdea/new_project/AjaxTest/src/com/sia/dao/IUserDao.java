package com.sia.dao;

import com.sia.bean.User;

import java.util.List;

public interface IUserDao {
    void add(User user);
    void update(User user);
    void del(Integer uid);
    User getOne(Integer uid);
    List<User> getAll();
    User getOneByName(String uname);
}
