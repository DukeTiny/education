package com.sia;

import com.sia.bean.User;
import com.sia.service.DaoFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<User> users = DaoFactory.getUserService().getAll();
        System.out.println(users.size());
    }
}
