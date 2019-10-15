package com.sia.service;

public class ServiceFactory {

    public static IEmpService getEmpService(){
        return new EmpServiceImpl();
    }
    public static IDeptService getDeptService(){
        return new DeptServiceImpl();
    }
}
