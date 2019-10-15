package com.woniu.thread;

public class ThreadPoolDemo implements Runnable {
	int i;
	public ThreadPoolDemo(int num){
		this.i = num;
	}
	public void run() {
		while(1<2){
			System.out.println(this.i);
		}
	}

}
