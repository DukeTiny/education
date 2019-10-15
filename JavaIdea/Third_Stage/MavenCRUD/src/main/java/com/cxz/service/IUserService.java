package com.cxz.service;

import com.cxz.bean.Page;
import com.cxz.bean.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    void update(User user);
    void delete(Integer id);
    List<User> find();
    User find(Integer id);
    Page findPageData(int p,int size);

}
