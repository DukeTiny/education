package com.cxz.h_createbean;

public class UserFactory {

    public static User getUser(){
        System.out.println("UserFactory.getUser");
        return new User();
    }

    public User getUser2(){
        System.out.println("UserFactory.getUser2");
        return new User();
    }

}
