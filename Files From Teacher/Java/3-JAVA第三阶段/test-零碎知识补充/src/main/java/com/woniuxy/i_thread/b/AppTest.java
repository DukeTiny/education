package com.woniuxy.i_thread.b;

// ����4���̣߳�����2����ͣ�ظ�һ��j���� ִ��++����������������ͣ��ִ�� j--������


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
				System.out.println(Thread.currentThread().getName() + "����:" + data.j);
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
				System.out.println(Thread.currentThread().getName() + "����:" + data.j);
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
