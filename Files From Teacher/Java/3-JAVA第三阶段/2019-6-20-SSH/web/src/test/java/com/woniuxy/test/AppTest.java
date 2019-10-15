package com.woniuxy.test;

import java.util.Random;

/*
 ThreadLocal，用于把一个变量，绑定到某一个线程上。在同一个线程中，总是能获取到这个变量。
 1. 保证每个线程都有各自的变量。
 2. 通过ThreadLocal还可以进行传参！
*/

public class AppTest {
	
	static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
	
	public static void f1() {
		// 生成一个随机数
		int r = new Random().nextInt(); 
		tl.set(r);
		System.out.println(Thread.currentThread().getName() + " f1生成了：" + r);
	}
	
	public static void f2() {
		// 获取f1中所生成的随机数
		int r = tl.get();
		System.out.println(Thread.currentThread().getName() + " f2获取了：" + r);
	}
	
	public static void main(String[] args) {
		
		for (int i = 1; i <= 2; i++) {
			Thread th = new Thread(new Runnable() {
				@Override
				public void run() {
					f1();
					f2();
				}
			});
			th.start();
		}
		
		
	}
	
}