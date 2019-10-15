package com.woniuxy.h_singleton.a;

import static org.junit.Assert.*;

import org.junit.Test;


/*
	 什么是单例模式： 一个类，只能有一个实例。
	 
	什么时候使用单例模式：当创建一个类的对象时，对象占用的资源特别多，且该对象的状态基本上不会变化。就可以考虑使用单例模式
		所谓对象的状态，就是程序运行时，某一刻对象的属性的取值。 
		比如，坦克大战中的地图类，只需要一个实例就够了！  比如，ApplicationContext，只需要一个就够了。
*/

// 单例模式： 饱汉式 ，由jvm保证静态块只执行一次，所以在多线程下，也不会破坏这种单例模式！
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
