package com.sia.dao;

import com.sia.bean.User;

import java.util.List;

public interface IUserDao {
    void add(User user);
    void update(User user);
    void del(Integer uid);
    User login(String uname,String upwd);
    User getOne(Integer uid);
    List getAll();
}
