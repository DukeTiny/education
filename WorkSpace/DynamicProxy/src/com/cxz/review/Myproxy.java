package com.cxz.review;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Myproxy {
	
	private BufferedReader br;

	public Object getProxy(Object obj,Interceptor interceptor) {
		ClassLoader cl = obj.getClass().getClassLoader();
		Class<?>[] interfaces = obj.getClass().getInterfaces();
		InvocationHandler handler = new MyHandler(obj,interceptor);
		Object proxy = Proxy.newProxyInstance(cl,interfaces,handler);
		return proxy;
	}
	
	
	public Object getProxy(Object proxy) throws Exception {
		List<Interceptor> list = new ArrayList<>();
		Reader reader = new FileReader("src/com/cxz/review/interceptor.txt");
		br = new BufferedReader(reader);
		String line = null;
		while((line=br.readLine())!=null) {
			Interceptor interceptor = (Interceptor)(Class.forName(line).newInstance());
			list.add(interceptor);
		}
		
		for (int i = list.size()-1; i >= 0; i--) {
			proxy = getProxy(proxy,list.get(i));
		}
		
		return proxy;
	}
}
