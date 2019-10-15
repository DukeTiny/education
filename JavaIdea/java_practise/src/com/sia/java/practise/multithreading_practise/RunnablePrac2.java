package com.sia.java.practise.multithreading_practise;

public class RunnablePrac2 implements Runnable {
    private int i = 3000;
    @Override
    public void run () {
        for( ; i>0;  ){
            System.out.println( Thread.currentThread() + "##" + i-- );
        }
    }


    public static void main(String[] args) {
        RunnablePrac2 rp1 = new RunnablePrac2();
        Thread t1 = new Thread( rp1 );
        Thread t2 = new Thread( rp1 );
        Thread t3 = new Thread( rp1 );
        t1.start();
        t2.start();
        t3.start();
    }
}
