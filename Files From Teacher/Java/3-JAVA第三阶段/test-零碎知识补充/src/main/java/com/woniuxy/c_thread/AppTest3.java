package com.woniuxy.c_thread;

class A implements Runnable {
	
	private Object obj;
	
	public A(Object obj) {
		this.obj = obj;
	}
	
	public void run() {
		while(true) {
			synchronized (obj) {   // 进入这个花括弧，线程就会尝试获取obj的锁； 如果锁已经被占了，则线程进入obj的就绪队列
				System.out.println("AAAA");
				System.out.println("BBBB");
				System.out.println("CCCC");
				System.out.println("DDDD");
				
				try {
					// 释放cpu，释放锁、还会唤醒obj就绪队列中的线程。 进入obj的wait的阻塞队列， 
					// 在wait阻塞队列中的线程是不会因为占有锁的线程，在退出同步块时而被唤醒的
					// wait阻塞队列中的线程，只能被obj的notify或notifyAll唤醒
					obj.notify();
					obj.wait();   
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}  // 出了花括弧，线程就会释放锁，还会obj对象的就绪队列中的等待该锁的其他线程全部唤醒。
		}
	}
}

// 就绪       
// wait  

class B implements Runnable {
	
	private Object obj;
	
	public B(Object obj) {
		this.obj = obj;
	}
	
	public void run() {
		while(true) {
			synchronized (obj) { // 进入这个花括弧，线程就会尝试获取obj的锁； 如果锁已经被占了，则线程进入obj的就绪队列
				System.out.println("1111");
				System.out.println("2222");
				System.out.println("3333");
				System.out.println("4444");
				
				try {
					// 释放cpu，释放锁。 进入obj的wait的阻塞队列， 
					// 在wait阻塞队列中的线程是不会因为占有锁的线程，在退出同步块时而被唤醒的
					// wait阻塞队列中的线程，只能被obj的notify或notifyAll唤醒
					obj.notify();
					obj.wait();   
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} // 出了花括弧，线程就会释放锁，还会obj对象的就绪队列中的等待该锁的其他线程全部唤醒。
		}
	}
}

public class AppTest3 {
	
	public static void main(String[] args) {
		
		// java中每个对象身上都有一把“锁”
		// 同一把锁，同一时刻只能被一个线程锁占有
		// 如果一个线程要获取一个已经被其他线程占有的锁，就会进入就绪队列（就阻塞了）
		Object obj = new Object();
		
		A a = new A(obj);
		B b = new B(obj);
		
		Thread th = new Thread(a);
		Thread th2 = new Thread(b);
		
		th.start();
		th2.start();
		
	}
}