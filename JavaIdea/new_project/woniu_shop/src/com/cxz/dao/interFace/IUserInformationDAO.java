package com.cxz.dao.interFace;

import com.cxz.bean.UserInformation;

import java.util.List;

public interface IUserInformationDAO {
    void add(UserInformation ui);
    void del(Integer userID);
    void update(UserInformation ui);
    UserInformation getOne(Integer userID);
    List<UserInformation> getAll();
    UserInformation findByNameAndPWD(String username, String password);
}
