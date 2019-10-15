package com.woniuxy.e_thread;

public class TestSync2 implements Runnable {  
   int b = 100;      
 
   void m1() throws InterruptedException {  
	   System.out.println("m1");
	   synchronized(this) {
	       b = 1000; 
	       Thread.sleep(500); // 释放cpu，锁没有释放。
	       System.out.println("b=" + b);  
	   } 
   }  
    void m2() throws InterruptedException {  
    	System.out.println("m2");
    	synchronized(this) {
	       Thread.sleep(250);   // 释放cpu。没有释放锁
	       b = 2000;  
	       System.out.println("m2:" + b);
    	}
   } 
 
   public static void main(String[] args) throws InterruptedException {  
       TestSync2 tt = new TestSync2();  
       Thread t = new Thread(tt); 
       t.start();  // main线程不会阻塞  t.start()--> tt.run(); --> run() 中this.m1()--> m1()中：synchronized(this)
       tt.m2();  // 250 
       System.out.println("main thread b=" + tt.b); 
   } 
 
   @Override  
   public void run() {  
       try {  
          m1();  
       } catch (InterruptedException e) {  
           e.printStackTrace();  
       }  
   }  
}  

// t.start（）先占cpu： 1000, 2000
//  tt.m2（） 先占cpu： 2000 1000
//                 1000 1000