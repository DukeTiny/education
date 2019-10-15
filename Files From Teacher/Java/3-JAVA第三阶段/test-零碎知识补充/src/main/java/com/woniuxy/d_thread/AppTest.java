package com.woniuxy.d_thread;

/*
  
 	1. 线程之间要通信，必须有一个共享对象。 恰恰就是使用共享对象的wait和notifyAll来实现通信的。 
	2.编写线程程序的时候，定义几个实现Runnable的类呢？ 取决于有多少个任务。有多少个任务，就创建多少个实现了Runnable接口的类
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
// 就绪队列：   A，
// 抢不到锁的阻塞队列：
// wait阻塞队列 : CB， 

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
