package com.cxz.e_hello;

public class Bear implements Toy{

    public Bear() {
        System.out.println("Bear.Bear");
    }

    @Override
    public void play() {
        System.out.println("Bear.play");
    }
}
