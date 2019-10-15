package com.woniuxy.test;

import java.util.Random;

/*
 ThreadLocal�����ڰ�һ���������󶨵�ĳһ���߳��ϡ���ͬһ���߳��У������ܻ�ȡ�����������
 1. ��֤ÿ���̶߳��и��Եı�����
 2. ͨ��ThreadLocal�����Խ��д��Σ�
*/

public class AppTest {
	
	static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
	
	public static void f1() {
		// ����һ�������
		int r = new Random().nextInt(); 
		tl.set(r);
		System.out.println(Thread.currentThread().getName() + " f1�����ˣ�" + r);
	}
	
	public static void f2() {
		// ��ȡf1�������ɵ������
		int r = tl.get();
		System.out.println(Thread.currentThread().getName() + " f2��ȡ�ˣ�" + r);
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