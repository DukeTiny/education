package com.sia.java.homework.java_2019_04_15_synchorized.print_letter_and_bread;

public class A implements Runnable {
    public Print p;

    public A ( Print p ){
       this.p = p;
    }
    @Override
    public void run() {
//        while ( true ){

//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            p.printNum();
        }

//        }

}
