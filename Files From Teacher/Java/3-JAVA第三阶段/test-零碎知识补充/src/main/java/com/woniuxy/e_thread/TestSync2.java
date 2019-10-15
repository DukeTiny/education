package com.woniuxy.e_thread;

public class TestSync2 implements Runnable {  
   int b = 100;      
 
   void m1() throws InterruptedException {  
	   System.out.println("m1");
	   synchronized(this) {
	       b = 1000; 
	       Thread.sleep(500); // �ͷ�cpu����û���ͷš�
	       System.out.println("b=" + b);  
	   } 
   }  
    void m2() throws InterruptedException {  
    	System.out.println("m2");
    	synchronized(this) {
	       Thread.sleep(250);   // �ͷ�cpu��û���ͷ���
	       b = 2000;  
	       System.out.println("m2:" + b);
    	}
   } 
 
   public static void main(String[] args) throws InterruptedException {  
       TestSync2 tt = new TestSync2();  
       Thread t = new Thread(tt); 
       t.start();  // main�̲߳�������  t.start()--> tt.run(); --> run() ��this.m1()--> m1()�У�synchronized(this)
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

// t.start������ռcpu�� 1000, 2000
//  tt.m2���� ��ռcpu�� 2000 1000
//                 1000 1000