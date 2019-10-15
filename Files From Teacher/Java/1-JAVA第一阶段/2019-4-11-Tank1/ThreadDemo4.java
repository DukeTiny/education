package com.woniu.thread;

public class ThreadDemo4 implements Runnable {
	String name;
	int tickets = 1000;
	public ThreadDemo4(){
	}
	
	public void run() {
		while(tickets>0){
			System.out.println(Thread.currentThread()+"窗口在卖第"+tickets--+"张票");
		}
	}

	public static void main(String[] args) {
		ThreadDemo4 td = new ThreadDemo4();
		
		Thread th1 = new Thread(td);
		Thread th2 = new Thread(td);
		Thread th3 = new Thread(td);
		th1.start();
		th2.start();
		th3.start();
	}

}
