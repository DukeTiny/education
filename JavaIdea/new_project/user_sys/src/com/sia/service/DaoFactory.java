package com.sia.service;

import com.sia.dao.IUserDao;
import com.sia.dao.UserDaoImpl;

public class DaoFactory {

    public static IUserDao getUserService(){
        return new UserDaoImpl();
    }

}
