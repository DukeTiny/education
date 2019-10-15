package com.woniuxy.c_thread;

import java.util.Arrays;

class Shelf {
	private String[] strs = "口 口 口 口 口 口".split(" ");
	private int i;
	public synchronized void put() {
			while(this.isFull()) {
				try {
					this.wait(); // 郭靖 张无忌
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			strs[i++] = "回";
			this.notify();
			System.out.println(Thread.currentThread().getName()+"放入:" + this);
	}
	public synchronized void get() {
			while(this.isEmpty()) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			strs[--i] = "口";
			this.notify();
			System.out.println(Thread.currentThread().getName()+"取出:" + this);
	}
	public boolean isFull() {
		return i == 6;
	}
	public boolean isEmpty() {
		return i == 0;
	}
	@Override
	public String toString() {
		return Arrays.toString(strs);
	}
}

class X implements Runnable {
	private Shelf sh;
	public X(Shelf sh) {
		this.sh = sh;
	}
	@Override
	public void run() {
		while(true) {
			sh.put();
		}
	}
}
class Y implements Runnable {
	private Shelf sh;
	public Y(Shelf sh) {
		this.sh = sh;
	}
	@Override
	public void run() {
		while(true) {
			sh.get();
		}
	}
}

public class AppTest4 {
	public static void main(String[] args) {
		Shelf sh = new Shelf();
		X x = new X(sh);
		Y y = new Y(sh);
		Thread th = new Thread(x, "郭靖");
		Thread th2 = new Thread(x, "张无忌");
		Thread th3 = new Thread(y, "黄蓉");
		Thread th4 = new Thread(y, "赵敏");
		
		th.start();
		th2.start();
		
		th3.start();
		th4.start();
	}
	
}
