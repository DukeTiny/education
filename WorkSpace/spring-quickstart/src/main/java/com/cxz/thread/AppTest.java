package com.cxz.thread;

import static org.junit.Assert.*;

import javax.security.auth.Subject;

import org.junit.Test;

public class AppTest {

//	@Test
//	public void testName() throws Exception {
//		Ticket ticket = new Ticket();
//		Thread t1 = new Thread(ticket,"东大街");
//		Thread t2 = new Thread(ticket,"西大街");
//		Thread t3 = new Thread(ticket,"南大街");
//		Thread t4 = new Thread(ticket,"北大街");
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		
//	}
//	
	public static void main(String[] args) {
		Data data = new Data();
		sub sub = new sub(data);
		add add = new add(data);
		Thread t1 = new Thread(sub);
		Thread t2 = new Thread(sub);
		Thread t3 = new Thread(add);
		Thread t4 = new Thread(add);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}


class Ticket implements Runnable {

	private int count = 100;
	public void run() {
		while (count>0) {
			synchronized (this) {
				if (count>0) {
					count--;
					System.out.println(Thread.currentThread().getName() + "买了一张票，还剩" + count + "张票");
				}
			}
		}
	}
}

class Data {
	int j=0;
}

class sub implements Runnable {

	Data data;
	
	public sub(Data data) {
		this.data = data;
	}
	public void run() {
		while (true) {
			synchronized (data) {
				data.j--;
				System.out.println(Thread.currentThread().getName() + " ::: " + data.j);
			}
		}
	}
}

class add implements Runnable {
	Data data;
	public add(Data data) {
		this.data = data;
	}
	public void run() {
		while (true) {
			synchronized (data) {
				data.j++;
				System.out.println(Thread.currentThread().getName() + " ::: " + data.j);
			}
		}
	}
}









