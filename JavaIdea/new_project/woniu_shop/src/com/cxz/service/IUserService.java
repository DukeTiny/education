package com.cxz.service;

import com.cxz.bean.UserInformation;

import java.util.List;

public interface IUserService {
    void add(UserInformation user);
    void update(UserInformation user);
    void del(Integer userID);
    UserInformation findOne(Integer userID);
    List<UserInformation> findALl();
    UserInformation findByNameAndPWD(String username,String password);
}
