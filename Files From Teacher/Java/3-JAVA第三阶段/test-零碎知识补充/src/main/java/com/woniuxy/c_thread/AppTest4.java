package com.woniuxy.c_thread;

import java.util.Arrays;

class Shelf {
	private String[] strs = "�� �� �� �� �� ��".split(" ");
	private int i;
	public synchronized void put() {
			while(this.isFull()) {
				try {
					this.wait(); // ���� ���޼�
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			strs[i++] = "��";
			this.notify();
			System.out.println(Thread.currentThread().getName()+"����:" + this);
	}
	public synchronized void get() {
			while(this.isEmpty()) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			strs[--i] = "��";
			this.notify();
			System.out.println(Thread.currentThread().getName()+"ȡ��:" + this);
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
		Thread th = new Thread(x, "����");
		Thread th2 = new Thread(x, "���޼�");
		Thread th3 = new Thread(y, "����");
		Thread th4 = new Thread(y, "����");
		
		th.start();
		th2.start();
		
		th3.start();
		th4.start();
	}
	
}
