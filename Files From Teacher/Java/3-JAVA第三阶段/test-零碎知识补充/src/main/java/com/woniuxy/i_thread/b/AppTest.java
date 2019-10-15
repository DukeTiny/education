package com.woniuxy.i_thread.b;

// 制作4个线程，其中2个不停地给一个j变量 执行++操作，另外两个不停地执行 j--操作。


class Data {
	public int j = 0;
}

class T implements Runnable {

	private Data data;
	
	public T(Data data) {
		this.data = data;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (data) {
				data.j++;
				System.out.println(Thread.currentThread().getName() + "加了:" + data.j);
			}
		}
	}
	
}

class S implements Runnable {

	private Data data;
	
	public S(Data data) {
		this.data = data;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (data) {
				data.j--;
				System.out.println(Thread.currentThread().getName() + "减了:" + data.j);
			}
		}
	}
	
}

public class AppTest {
	public static void main(String[] args) {
		Data data = new Data();
		
		T t = new T(data);
		S s = new S(data);
		
		Thread th = new Thread(t);
		Thread th2 = new Thread(s);
		
		th.start();
		th2.start();
	}
}
