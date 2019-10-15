package com.woniuxy.h_singleton.a;

import static org.junit.Assert.*;

import org.junit.Test;


/*
	 ʲô�ǵ���ģʽ�� һ���ֻ࣬����һ��ʵ����
	 
	ʲôʱ��ʹ�õ���ģʽ��������һ����Ķ���ʱ������ռ�õ���Դ�ر�࣬�Ҹö����״̬�����ϲ���仯���Ϳ��Կ���ʹ�õ���ģʽ
		��ν�����״̬�����ǳ�������ʱ��ĳһ�̶�������Ե�ȡֵ�� 
		���磬̹�˴�ս�еĵ�ͼ�ֻ࣬��Ҫһ��ʵ���͹��ˣ�  ���磬ApplicationContext��ֻ��Ҫһ���͹��ˡ�
*/

// ����ģʽ�� ����ʽ ����jvm��֤��̬��ִֻ��һ�Σ������ڶ��߳��£�Ҳ�����ƻ����ֵ���ģʽ��
class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton() {
		System.out.println("Singleton.Singleton()");
	}
	
	public static Singleton getInstance() {
		return instance;
	}
}

class T implements Runnable {
	@Override
	public void run() {
		Singleton instance = Singleton.getInstance();
		System.out.println(Thread.currentThread().getName() + ": " + instance);
	}
}

public class AppTest {

	@Test
	public void test() throws Exception {
		T t = new T();
		for (int i = 1; i <= 50; i++) {
			Thread th = new Thread(t);
			th.start();
		}
	}
}
