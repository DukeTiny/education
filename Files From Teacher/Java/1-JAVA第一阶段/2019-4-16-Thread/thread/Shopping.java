package com.woniu.thread;

public class Shopping {
	int num;

	public synchronized void create() {
		num++;
		System.out.println(Thread.currentThread() + "��������" + (num) + "����Ʒ");
	}
	public synchronized void delete() {
		if(num>0){
			System.out.println(Thread.currentThread() + "���ѵ�" + (num) + "����Ʒ");
			num--;
		}
	}
}
