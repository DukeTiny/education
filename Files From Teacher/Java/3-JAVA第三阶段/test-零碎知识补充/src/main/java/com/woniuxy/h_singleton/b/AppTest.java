package com.woniuxy.h_singleton.b;

import static org.junit.Assert.*;

import org.junit.Test;

/*
	 ʲô�ǵ���ģʽ�� һ���ֻ࣬����һ��ʵ����
	 
	ʲôʱ��ʹ�õ���ģʽ��������һ����Ķ���ʱ������ռ�õ���Դ�ر�࣬�Ҹö����״̬�����ϲ���仯���Ϳ��Կ���ʹ�õ���ģʽ
		��ν�����״̬�����ǳ�������ʱ��ĳһ�̶�������Ե�ȡֵ�� 
		���磬̹�˴�ս�еĵ�ͼ�ֻ࣬��Ҫһ��ʵ���͹��ˣ�  ���磬ApplicationContext��ֻ��Ҫһ���͹��ˡ�
*/

// ����ģʽ������ʽ  
class Singleton {
	private volatile static Singleton instance = null;
	
	private Singleton() {
		System.out.println("Singleton.Singleton()");
	}
	
	public static Singleton getInstance() {
		if (instance == null) {	// ����instance��Ϊnull��ʱ�򣬾Ͳ������ˣ�
			synchronized (Singleton.class) {
				if (instance == null) {	// ��ֻ֤newһ��
					System.out.println("����if��");
					instance = new Singleton();  //  ��������class�� jvmΪ���Ż����� ���ָ��������� 
					// �������
					// �������Եĳ�ʼֵ
					// ���ض���
				}
			}
		}
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
		for (int i = 1; i <= 2; i++) {
			Thread th = new Thread(t);
			th.start();
		}
	}
}
