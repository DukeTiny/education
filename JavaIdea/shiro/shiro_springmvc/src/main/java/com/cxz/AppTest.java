package com.cxz;

import org.apache.shiro.crypto.hash.SimpleHash;

public class AppTest {

    public static void main(String[] args) {
        Object o = new SimpleHash("MD5","hahawanghu","Duke",1027);
        System.out.println(o);
    }


}
