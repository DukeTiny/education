package com.sia.java.homework.java_2019_04_15_synchorized.make_bread;

public class TestDrive {

    public static void main(String[] args) {
        Bread b = new Bread();
        A a = new A( b );
        B c = new B( b );
        new Thread( a ).start();
        new Thread( c ).start();
    }


}
