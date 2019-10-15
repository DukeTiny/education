package com.sia.java.practise.multithreading_practise;

public class SynchronizedPrac extends Thread {
    private boolean flag;
    private String str1 = "AAAAA";
    private String str2 = "BBBBB";

    public SynchronizedPrac(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run () {
        if( this.flag ) {
            synchronized ( str1 ){
                System.out.println(str1 + this.flag);
                synchronized (str2 ){
                    System.out.println( str2+this.flag );
                }
            }
        }
        else {
            synchronized ( str2 ) {
                System.out.println(str2 + this.flag);
                synchronized (str1 ){
                    System.out.println( str1+this.flag );
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread ( new SynchronizedPrac( true ) ).start();
        new Thread ( new SynchronizedPrac( false ) ).start();
    }
}
