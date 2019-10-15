package com.sia.service;

import com.sia.bean.User;

import java.util.List;

public interface IUserService {

    void add(User user);
    void update(User user);
    void del(Integer uid);
    User getOne(Integer uid);
    User getOneByName(String uname);
    List<User> getAll();

}
