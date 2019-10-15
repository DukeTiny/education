package com.woniuxy.i_thread.a;

// ��100�Ż�Ʊ��ģ��4��������Ʊ

// ������������������ֶ���̣߳�ֻ��һ������������ù��������࣬ʵ��Runnable��
// ������������������ֶ���̣߳�ֻ�ж�����񣬾�Ҫ��������඼ʵ��Runnable����ʱ���������࣬����������ù���������ʵ��Runnable��
class Ticket implements Runnable {
	private int count = 100;
	@Override
	public void run() {
		while(count > 0) {
			synchronized (this) {
				if(count > 0) {
					count--;
					System.out.println(Thread.currentThread().getName() + "������һ��Ʊ����ʣ��" + count);
				}
			}
		}
	}
}

public class AppTest {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		Thread th = new Thread(t, "�����");
		Thread th2 = new Thread(t, "�ϴ��");
		Thread th3 = new Thread(t, "�����");
		Thread th4 = new Thread(t, "�����");
		th.start();  // t.run();
		th2.start();  // t.run();
		th3.start();  // t.run();
		th4.start();  // t.run();
	}
}
