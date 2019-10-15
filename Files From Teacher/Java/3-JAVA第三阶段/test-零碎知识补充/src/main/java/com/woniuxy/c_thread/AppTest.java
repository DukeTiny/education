package com.woniuxy.c_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppTest {
	public static void main(String[] args) {
		
//		ExecutorService es = Executors.newFixedThreadPool(3);
//		es.submit(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 1; i <= 10; i++) {
//					System.out.println(Thread.currentThread().getName() + ":" + i);
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		es.submit(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 100; i <= 110; i++) {
//					System.out.println(Thread.currentThread().getName() + ":" + i);
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		es.submit(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 1000; i <= 1010; i++) {
//					System.out.println(Thread.currentThread().getName() + ":" + i);
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		
//		
//		es.submit(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 3000; i <= 3010; i++) {
//					System.out.println(Thread.currentThread().getName() + ":" + i);
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});

		
		// 缓存线程池，没有上线，来几个任何，就现场做几个线程。
		// 当线程执行任务完成后，不会立即销毁，而是先还回池中
		// 当线程超过一定的闲置时间后，线程池就会把该线程销毁。
//		ExecutorService es = Executors.newCachedThreadPool();
//		
//		for (int i = 1; i <=100; i++) {
//			es.submit(new Runnable() {
//				@Override
//				public void run() {
//					while(true) {
//						System.out.println(Thread.currentThread().getName());
//					}
//				}
//			});
//		}
		
		
		
	}
	
}
