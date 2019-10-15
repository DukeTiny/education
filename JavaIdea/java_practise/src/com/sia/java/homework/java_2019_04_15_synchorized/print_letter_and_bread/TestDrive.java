package com.sia.java.homework.java_2019_04_15_synchorized.print_letter_and_bread;

public class TestDrive {

    public static void main(String[] args) throws InterruptedException {

        Print p = new Print();
        A a = new A(p);
        B b = new B(p);

        for( int i=0; i<26; i++ ){
            Thread t1 = new Thread(a);
            t1.start(); t1.join();
            Thread t2 = new Thread(b);
            t2.start(); t2.join();
        }
    }

}
