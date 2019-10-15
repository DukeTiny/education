package com.woniu.thread;

public class ThreadDemo extends Thread {
	int i;
	public ThreadDemo(int num){
		this.i= num;
	}
	public void run() {
		while(1<2){
			System.out.println(this.i);
		}
	}

}
