package com.sia.dao;

public class DaoFactory {
    public static IUserDao getUserDAO(){
        return new UserDaoImpl();
    }
}
