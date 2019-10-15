package com.sia.java.homework.java_2019_04_15_synchorized.make_bread;

public class B implements Runnable{
    Bread b;
    public B(Bread b ){
        this.b = b;
    }
    @Override
    public void run() {
        while ( true ){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.eat();
        }
    }
}
