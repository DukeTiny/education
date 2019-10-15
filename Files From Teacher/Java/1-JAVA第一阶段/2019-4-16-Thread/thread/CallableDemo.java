package com.woniu.thread;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<Integer> {
	int i;
	public CallableDemo(int num){
		this.i = num;
	}
	public Integer call() throws Exception {
		System.out.println("in call...");
		return 2;
	}

}
