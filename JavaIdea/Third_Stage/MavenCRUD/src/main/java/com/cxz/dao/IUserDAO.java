package com.cxz.dao;

import com.cxz.bean.User;

import java.util.List;

public interface IUserDAO {

    void save(User user);
    void update(User user);
    void delete(Integer id);
    List<User> find();
    User find(Integer id);
    int getRowCount();
    List<User> find(int startLine,int size);

}
