package com.sia.service;

public class ServiceFactory {

    public static IStuService getStuService(){
        return new StuServiceImpl();
    }

}
