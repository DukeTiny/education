package com.sia.dao;

public class DaoFactory {

    public static IStuDao getStuDao(){
        return new StudaoImpl();
    }

}
