package com.sia.java.practise.multithreading_practise;

public class RunnablePrac1 implements Runnable {
    @Override
    public void run () {
        for( int i=0; i<1000; i++ ){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        RunnablePrac1 rp1 = new RunnablePrac1();
        RunnablePrac1 rp2 = new RunnablePrac1();
        RunnablePrac1 rp3 = new RunnablePrac1();
        Thread t1 = new Thread( rp1 );
        Thread t2 = new Thread( rp2 );
        Thread t3 = new Thread( rp3 );
        t1.start();
        t2.start();
        t3.start();
    }
}
