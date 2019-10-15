package com.woniu.demo;

public class ThreadDemo2 {
	
	
	public static void main(String[] args) {
		Print p = new Print();
		
		A a = new A(p);
		B b = new B(p);
		
		a.start();
		b.start();
	}
	
}
//ÿ��ӡһ�Σ����õ�ǰ�߳� wait();���������߳�nodify()
//������һ�����������ĸ�ʹ����ֵķ���
class Print{
	boolean flag = true;
	int count = 1;
	//
	public synchronized void printNum(){
		while(!flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print(count*2-1);
		System.out.print(count*2);
		flag = false;
		notify();
	}
	public synchronized void printChar(){
		while(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print((char)((count-1)+'a'));
		count++;
		flag = true;
		notify();
	}
}


//����һ�������ֵ��߳�
class A extends Thread{
	Print p;
	public A(Print p){
		this.p = p;
	}
	public void run() {
		for(int i=1;i<=26;i++){
			p.printNum();
		}
	}
}
//����һ������ĸ���߳�
class B extends Thread{
	Print p;
	public B(Print p){
		this.p = p;
	}
	public void run() {
		for(int i=1;i<=26;i++){
			p.printChar();
		}
	}
}

