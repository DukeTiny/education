package com.sia.java.homework.java_2019_04_15_synchorized.make_bread;

public class Bread {
    static int i;
    synchronized void make() {
        i++;
        System.out.println("Mom is making the " + i + " bread");
    }
    synchronized void eat() {
        if( i>0 ){
            System.out.println("I'am is eating the " + i + " bread");
            i--;
        }
    }

}
