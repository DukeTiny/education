package com.woniu.thread;

public class Shopping {
	int num;

	public synchronized void create() {
		num++;
		System.out.println(Thread.currentThread() + "生产出第" + (num) + "个商品");
	}
	public synchronized void delete() {
		if(num>0){
			System.out.println(Thread.currentThread() + "消费第" + (num) + "个商品");
			num--;
		}
	}
}
