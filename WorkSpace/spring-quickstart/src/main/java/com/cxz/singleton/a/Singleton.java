package com.cxz.singleton.a;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class Singleton {
	
	private static Singleton instance = null;
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	
	public static Singleton getSingleton() {
		if (instance==null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			} 
		}
		return instance;
	}
	
	

}

class T implements Runnable{
	
	@Override
	public void run() {
		Singleton instance = Singleton.getSingleton();
		System.out.println(Thread.currentThread().getName()+instance);
	}
	
}
	
	

