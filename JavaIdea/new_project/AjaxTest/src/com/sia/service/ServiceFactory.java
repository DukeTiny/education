package com.sia.service;

public class ServiceFactory {
    public static IUserService getUserService(){
        return new UserServiceImpl();
    }
}
