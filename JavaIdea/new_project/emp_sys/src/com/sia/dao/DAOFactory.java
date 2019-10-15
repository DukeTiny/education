package com.sia.dao;

public class DAOFactory {

    public static IDeptDAO getDeptDao() {
        return new DeptDAOImpl();
    }

    public static IEmpDAO getEmpDao(){
        return  new EmpDAOImpl();
    }

}
