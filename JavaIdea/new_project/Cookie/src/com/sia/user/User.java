package com.sia.user;

import java.util.Vector;

public class User {

    public static Vector<String> vectors = new Vector<String>();

    public static void addUser(String loginUserName) {
        vectors.add(loginUserName);
    }

    public static void removeUser(String loginUserName) {
        vectors.remove(loginUserName);
    }

    public static int getUserNum(){
        return vectors.size();
    }
}
