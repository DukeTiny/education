package com.woniuxy.c_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class T implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		for (int i = 1; i <=  10; i++) {
			System.out.println("T:" + i);
			TimeUnit.SECONDS.sleep(1);
		}
		return 5;
	}
	
}

public class AppTest2 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		T t = new T();
		
		Future<Integer> f = es.submit(t);  // 10
		
		System.out.println("i am here");
		
		System.out.println(f.get() + "~~~");  // Í¬²½×èÈû
		
		System.out.println("where are you");
		
		es.shutdown();
	}
}
 