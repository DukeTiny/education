package com.woniu.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ThreadDemo td1 = new ThreadDemo(111111);
//		ThreadDemo td2 = new ThreadDemo(222222);
//		td1.start();
//		td2.start();
		
//		RunnableDemo rd1 = new RunnableDemo(11111);
//		RunnableDemo rd2 = new RunnableDemo(22222);
//		Thread th1 = new Thread(rd1);
//		Thread th2 = new Thread(rd2);
//		th1.start();
//		th2.start();
		
//		CallableDemo cd1 = new CallableDemo(1111);
//		CallableDemo cd2 = new CallableDemo(2222);
//		
//		FutureTask ft = new FutureTask(cd1);
//		FutureTask ft2 = new FutureTask(cd2);
//		
//		Thread th1 = new Thread(ft);
//		Thread th2 = new Thread(ft2);
//		
//		th1.start();
//		th2.start();
		
//		ExecutorService executor = Executors.newFixedThreadPool(10);
//		for(int i=1;i<=10;i++){
//			ThreadPoolDemo tpd = new ThreadPoolDemo(i);
//			executor.execute(tpd);
//		}
		
//		ExecutorService executor = Executors.newFixedThreadPool(5);
//		CallableDemo cd = new CallableDemo(1);
//		Future f = executor.submit(cd);
//		Object obj = f.get();
//		System.out.println(obj);
		
		Shopping s = new Shopping();
		Demo2 d2 = new Demo2(s);
		Demo3 d3 = new Demo3(s);
		Demo3 d4 = new Demo3(s);
		Thread th1 = new Thread(d2);
		Thread th2 = new Thread(d3);
		Thread th3 = new Thread(d4);
		th1.start();
		th2.start();
		th3.start();
	}

}
