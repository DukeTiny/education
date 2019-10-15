package com.sia.java.homework.java_2019_04_15_synchorized.print_letter_and_bread;

public class B implements Runnable {
    public Print p;

    public B(Print p ){
       this.p = p;
    }
    @Override
    public void run() {
//        while ( true ){

            p.printLetter();

//        }
    }
}
