package com.cxz;

import java.util.function.Supplier;

public class Test {

    public static String getString( Supplier<String> sup ) {
        return sup.get();
    }

    public static void main(String[] args) {
        System.out.println(getString(()-> "侬好"));
    }


}
