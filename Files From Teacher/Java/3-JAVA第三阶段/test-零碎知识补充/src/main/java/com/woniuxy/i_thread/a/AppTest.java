package com.woniuxy.i_thread.a;

// 有100张火车票，模拟4个窗口卖票

// 如果，经过分析，发现多个线程，只有一个任务，则可以让共享对象的类，实现Runnable。
// 如果，经过分析，发现多个线程，只有多个任务，就要创建多个类都实现Runnable，此时共享对象的类，单独定义别让共享对象的类实现Runnable。
class Ticket implements Runnable {
	private int count = 100;
	@Override
	public void run() {
		while(count > 0) {
			synchronized (this) {
				if(count > 0) {
					count--;
					System.out.println(Thread.currentThread().getName() + "卖出了一张票，还剩：" + count);
				}
			}
		}
	}
}

public class AppTest {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		Thread th = new Thread(t, "北大街");
		Thread th2 = new Thread(t, "南大街");
		Thread th3 = new Thread(t, "东大街");
		Thread th4 = new Thread(t, "西大街");
		th.start();  // t.run();
		th2.start();  // t.run();
		th3.start();  // t.run();
		th4.start();  // t.run();
	}
}
