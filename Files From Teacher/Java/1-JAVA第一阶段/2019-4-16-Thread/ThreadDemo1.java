package com.woniu.demo;

public class ThreadDemo1 {

	public static void main(String[] args) {
		//join()
		Thread th1 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("in th1 Thread...");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("end th1 Thread...");
			}
		});
		
		Thread th2 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("end th2 Thread...");
			}
		});
		
		th1.start();
		try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.start();

	}

}
