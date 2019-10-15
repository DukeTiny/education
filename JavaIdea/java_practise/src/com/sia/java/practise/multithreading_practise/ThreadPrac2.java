package com.sia.java.practise.multithreading_practise;

public class ThreadPrac2 extends Thread {
    private static int i = 3000;
    private String name;

    public ThreadPrac2( String name ) {
        this.name = name;
    }
    @Override
    public void run () {
        for( ; i>0;  ){
            System.out.println( this.name + "," + i-- );
        }
    }

    public static void main(String[] args) {
        ThreadPrac2 tp1 = new ThreadPrac2("A");
        ThreadPrac2 tp2 = new ThreadPrac2("B");
        ThreadPrac2 tp3 = new ThreadPrac2("C");
        tp1.start();
        tp2.start();
        tp3.start();
    }

}
