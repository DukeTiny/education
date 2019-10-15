package com.sia.java.practise.multithreading_practise;

public class ThreadPoolPrac implements Runnable{

    private int i;

    public ThreadPoolPrac( int num ){
        this.i = num;
    }
    @Override
    public void run() {
        while ( true ) {
            System.out.println( this.i );
        }
    }
}
