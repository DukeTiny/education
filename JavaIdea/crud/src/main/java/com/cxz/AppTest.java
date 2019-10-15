package com.cxz;

import com.mysql.cj.util.TimeUtil;
import sun.misc.ThreadGroupUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppTest {

    // main方法有两个线程，一个运行我们在main写的代码，一个是JVM垃圾回收机制的线程。
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T1 t2 = new T1();
        T1 t3 = new T1();
        T2 t4 = new T2();

        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(t1);
        es.submit(t2);
        es.submit(t4);
        es.submit(t3);



    }
//
//    private void a(){
//        System.out.println("AppTest.a");
//        b();
//    }
//    private void b(){
//        System.out.println("AppTest.b");
//        c();
//    }
//    private void c(){
//        System.out.println("AppTest.c");
//        d();
//    }
//    private void d(){
//        System.out.println("AppTest.d");
//        e();
//    }
//    private void e(){
//        System.out.println("AppTest.e");
//    }
//
}
class T1 extends Thread {

    @Override
    public void run() {
        for( int i=0; i<10; i++ ) {
//            try {
////                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "###########=="+i);
        }
    }
}

class T2 extends Thread {

    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName()+"你在哪儿，我的线程" );
    }
}