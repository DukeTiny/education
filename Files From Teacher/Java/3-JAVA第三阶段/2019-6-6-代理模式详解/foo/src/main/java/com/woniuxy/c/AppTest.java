package com.woniuxy.c;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.junit.Test;

/*
 b包中，显示了jdk的动态代理的使用，可以看出动态代理确实十分强大！
   但是，缺点是动态代理用起来比较麻烦，让一般的程序猿使用动态代理，要求有些高！
 我们最好封装一下，简化jdk动态代理的使用。
*/

class MyHandler implements InvocationHandler {

	private Object target;
	
	public MyHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName()+"开始，参数是：" + Arrays.toString(args));
		
		if(args != null) {
			for (Object obj : args) {
				if(obj instanceof Integer) {
					Integer i = (Integer) obj;
					if(i < 1) {
						throw new RuntimeException("参数必须大于0");
					}
				}
			}
		}
		
		// 放行，这里就是调用真正的目标方法，真实方法
		Object r = null;
		r = method.invoke(target, args);  
		
		System.out.println(method.getName()+"结束，结果是：" + r);

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
		// 创建目标对象
		ICalc c = new CalcImpl();
		MyProxy mp = new MyProxy();
		ICalc proxy = (ICalc) mp.getProxy(c);
		proxy.add(1, 2);
	}
}

