package com.woniu.test;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class cls = Panda.class;
		Method method = cls.getMethod("eat", String.class);
		System.out.println(method);
	}
}
