package com.woniu.thread;

public class RunnableDemo implements Runnable {
	int i;
	public RunnableDemo(int num){
		this.i = num;
	}
	public void run() {
		while(1<2){
			System.out.println(this.i);
		}
	}

}
