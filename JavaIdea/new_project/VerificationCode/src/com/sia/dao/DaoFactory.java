package com.sia.dao;

public class DaoFactory {

    public static IDeptDAO getDeptDAO(){
        return new DeptDaoImpl();
    }

}
