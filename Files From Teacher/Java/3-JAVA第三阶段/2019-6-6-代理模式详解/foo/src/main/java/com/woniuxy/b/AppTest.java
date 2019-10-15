package com.woniuxy.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.junit.Test;

class MyHandler implements InvocationHandler {

	private Object target;
	
	
	public MyHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName()+"��ʼ�������ǣ�" + Arrays.toString(args));
		
		for (Object obj : args) {
			if(obj instanceof Integer) {
				Integer i = (Integer) obj;
				if(i < 1) {
					throw new RuntimeException("�����������0");
				}
			}
		}
		
		// ���У�������ǵ���������Ŀ�귽������ʵ����
		Object r = null;
		r = method.invoke(target, args);  
		System.out.println(method.getName()+"����������ǣ�" + r);

		return r;
	}
	
}

public class AppTest {
	
	@Test
	public void test() throws Exception {
		 ICalc c = new CalcImpl();
		 
		// ���ö�̬��������һ���������.
		// ���ö�̬���������������ʱ����Ҫ����3������
		
		// ��һ��������ClassLoader�����������
		/*
		 	������������þ�������������ġ�������ʵ����һ����Ķ���ʱ���������һ�����ȰѸ�����ֽ�����ص��ڴ��С�
		 	Ȼ�������ڴ��е��ֽ������������ʵ����
		 	����Ĵ�����Ȼû��ʹ�ù��������������󣬶���ʹ�ö�̬������ôһ�֡����������ķ�ʽ����������ġ����Ǿ����ǲ������ķ�ʽ
		 	��������Ҳ��Ȼ��Ҫ��������������ֽ��뵽�ڴ��С�
		*/
		ClassLoader cl = AppTest.class.getClassLoader(); 
		
		
		// �ڶ���������Class[] �ֽ�������
		/*
		 	����Ĵ��룬�����������������ģ������������֮ǰ��jvm�����ڴ��ж�̬������һ�����ֽ��룬����ֽ����ʾ������Զ�ʵ��
		 	�ڶ��������еĽӿ�.
		*/
		Class[] interfaces = new Class[] {ICalc.class};
		
		// ������������InvocationHandler
		/*
		 	ÿ�ζԴ�������κη����ĵ��ã���������������ķ���������ͳͳ����InvocationHandler��invoke�����У�
		*/
		MyHandler mh = new MyHandler(c);
		
		ICalc proxy = (ICalc)Proxy.newProxyInstance(cl, interfaces, mh);
		
		Object obj = proxy.add(1, -2);
		System.out.println(obj);
		
		
	}
}
