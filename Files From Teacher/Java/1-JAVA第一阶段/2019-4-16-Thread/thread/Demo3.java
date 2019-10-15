package com.woniu.thread;

public class Demo3 implements Runnable {
	Shopping s;
	public Demo3(Shopping shopping){
		this.s = shopping;
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s.delete();
		}

	}
	
}
