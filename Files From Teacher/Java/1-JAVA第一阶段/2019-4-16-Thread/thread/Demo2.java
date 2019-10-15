package com.woniu.thread;

public class Demo2 implements Runnable {
	Shopping s;
	public Demo2(Shopping shopping){
		this.s = shopping;
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s.create();
		}
		
	}
		
	
}
