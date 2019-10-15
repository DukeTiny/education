package com.woniuxy.d_thread;

/*
  
 	1. �߳�֮��Ҫͨ�ţ�������һ��������� ǡǡ����ʹ�ù�������wait��notifyAll��ʵ��ͨ�ŵġ� 
	2.��д�̳߳����ʱ�򣬶��弸��ʵ��Runnable�����أ� ȡ�����ж��ٸ������ж��ٸ����񣬾ʹ������ٸ�ʵ����Runnable�ӿڵ���
*/

class A implements Runnable {
	
	private Foo f;
	public A(Foo f) {
		this.f = f;
	}


	@Override
	public void run() {
		while(true) {
			synchronized (f) {
				
				while(f.flag != 1) {
					try {
						f.wait(); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("A");
				f.flag = 2;
				f.notifyAll();
				
			}
		}
	}
}
class B implements Runnable {
	private Foo f;
	public B(Foo f) {
		this.f = f;
	}


	@Override
	public void run() {
		while(true) {
			synchronized (f) {
				while(f.flag != 2) {
					try {
						f.wait(); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("B");
				f.flag = 3;
				f.notifyAll();
			}
		}
	}
}
class C implements Runnable {
	private Foo f;
	public C(Foo f) {
		this.f = f;
	}


	@Override
	public void run() {
		while(true) {
			synchronized (f) {
				while(f.flag != 3) {
					try {
						f.wait(); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("C");
				f.flag = 1;
				f.notifyAll();
			}
		}
	}
}

class Foo {
	public int flag = 1;
}
// �������У�   A��
// �����������������У�
// wait�������� : CB�� 

public class AppTest {
	public static void main(String[] args) {
		
		Foo f = new Foo();
		
		A a = new A(f);
		B b = new B(f);
		C c = new C(f);
		
		Thread th = new Thread(a);
		Thread th2 = new Thread(b);
		Thread th3 = new Thread(c);
		th.start();
		th2.start();
		th3.start();
	}
}
