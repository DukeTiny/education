package com.cxz.service;

import com.cxz.po.UserLogin;

import java.util.List;

public interface IUserLoginService {
 
   void add(UserLogin userLogin);

    void update(UserLogin userLogin,String pk_name);

    void del(Integer id);

    UserLogin getOne(Integer id);

    List<UserLogin> getAll();
}