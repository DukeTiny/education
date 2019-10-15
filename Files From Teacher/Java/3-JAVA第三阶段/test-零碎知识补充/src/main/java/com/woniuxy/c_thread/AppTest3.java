package com.woniuxy.c_thread;

class A implements Runnable {
	
	private Object obj;
	
	public A(Object obj) {
		this.obj = obj;
	}
	
	public void run() {
		while(true) {
			synchronized (obj) {   // ����������������߳̾ͻ᳢�Ի�ȡobj������ ������Ѿ���ռ�ˣ����߳̽���obj�ľ�������
				System.out.println("AAAA");
				System.out.println("BBBB");
				System.out.println("CCCC");
				System.out.println("DDDD");
				
				try {
					// �ͷ�cpu���ͷ��������ỽ��obj���������е��̡߳� ����obj��wait���������У� 
					// ��wait���������е��߳��ǲ�����Ϊռ�������̣߳����˳�ͬ����ʱ�������ѵ�
					// wait���������е��̣߳�ֻ�ܱ�obj��notify��notifyAll����
					obj.notify();
					obj.wait();   
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}  // ���˻��������߳̾ͻ��ͷ���������obj����ľ��������еĵȴ������������߳�ȫ�����ѡ�
		}
	}
}

// ����       
// wait  

class B implements Runnable {
	
	private Object obj;
	
	public B(Object obj) {
		this.obj = obj;
	}
	
	public void run() {
		while(true) {
			synchronized (obj) { // ����������������߳̾ͻ᳢�Ի�ȡobj������ ������Ѿ���ռ�ˣ����߳̽���obj�ľ�������
				System.out.println("1111");
				System.out.println("2222");
				System.out.println("3333");
				System.out.println("4444");
				
				try {
					// �ͷ�cpu���ͷ����� ����obj��wait���������У� 
					// ��wait���������е��߳��ǲ�����Ϊռ�������̣߳����˳�ͬ����ʱ�������ѵ�
					// wait���������е��̣߳�ֻ�ܱ�obj��notify��notifyAll����
					obj.notify();
					obj.wait();   
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} // ���˻��������߳̾ͻ��ͷ���������obj����ľ��������еĵȴ������������߳�ȫ�����ѡ�
		}
	}
}

public class AppTest3 {
	
	public static void main(String[] args) {
		
		// java��ÿ���������϶���һ�ѡ�����
		// ͬһ������ͬһʱ��ֻ�ܱ�һ���߳���ռ��
		// ���һ���߳�Ҫ��ȡһ���Ѿ��������߳�ռ�е������ͻ����������У��������ˣ�
		Object obj = new Object();
		
		A a = new A(obj);
		B b = new B(obj);
		
		Thread th = new Thread(a);
		Thread th2 = new Thread(b);
		
		th.start();
		th2.start();
		
	}
}