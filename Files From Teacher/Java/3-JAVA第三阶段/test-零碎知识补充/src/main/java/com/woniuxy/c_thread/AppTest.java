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

		
		// �����̳߳أ�û�����ߣ��������κΣ����ֳ��������̡߳�
		// ���߳�ִ��������ɺ󣬲����������٣������Ȼ��س���
		// ���̳߳���һ��������ʱ����̳߳ؾͻ�Ѹ��߳����١�
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
