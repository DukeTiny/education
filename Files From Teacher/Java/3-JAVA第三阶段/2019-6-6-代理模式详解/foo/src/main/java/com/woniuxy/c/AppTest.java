package com.woniuxy.c;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.junit.Test;

/*
 b���У���ʾ��jdk�Ķ�̬�����ʹ�ã����Կ�����̬����ȷʵʮ��ǿ��
   ���ǣ�ȱ���Ƕ�̬�����������Ƚ��鷳����һ��ĳ���Գʹ�ö�̬����Ҫ����Щ�ߣ�
 ������÷�װһ�£���jdk��̬�����ʹ�á�
*/

class MyHandler implements InvocationHandler {

	private Object target;
	
	public MyHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName()+"��ʼ�������ǣ�" + Arrays.toString(args));
		
		if(args != null) {
			for (Object obj : args) {
				if(obj instanceof Integer) {
					Integer i = (Integer) obj;
					if(i < 1) {
						throw new RuntimeException("�����������0");
					}
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



class MyProxy {
	
	public Object getProxy(Object target) {
		ClassLoader cl = MyProxy.class.getClassLoader(); 
		Class[] interfaces = target.getClass().getInterfaces();  // IUserDao
		MyHandler mh = new MyHandler(target);
		Object proxy = Proxy.newProxyInstance(cl, interfaces, mh);
		return proxy;
	}
}

// ====================================================================================



public class AppTest {
	
	@Test
	public void test() throws Exception {
		// ����Ŀ�����
		ICalc c = new CalcImpl();
		MyProxy mp = new MyProxy();
		ICalc proxy = (ICalc) mp.getProxy(c);
		proxy.add(1, 2);
	}
}

