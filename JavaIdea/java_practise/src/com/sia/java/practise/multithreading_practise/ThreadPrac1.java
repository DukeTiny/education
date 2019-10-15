package com.sia.java.practise.multithreading_practise;

public class ThreadPrac1 extends Thread {

    @Override
    public void run () {
        for( int i=0; i<1000; i++ ){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ThreadPrac1 tp1 = new ThreadPrac1();
        ThreadPrac1 tp2 = new ThreadPrac1();
        ThreadPrac1 tp3 = new ThreadPrac1();
        tp1.start();
        tp2.start();
        tp3.start();
    }

}
