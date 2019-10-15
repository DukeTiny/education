package com.sia.dao;

import com.sia.bean.User;

import java.util.List;

public interface IUserDao {
    void add(User user);
    void del(Integer uid);
    void update(User user);
    User getLoginUser(String uname,String upwd);
    List<User> getAll();
}
