package com.woniuxy.b_reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

import org.junit.Test;

/*
 ���������ʲô��
 ��java��������ʱ���ܻ�ȡ������ֶΡ�����������������Ϣ��

��������Ǹ�ʲô�ģ�
������������ܵģ�

����֪����javaԴ�ļ�������֮�󶼻�õ��ֽ����ļ�������Ϊ����������Զ�������class�ļ�Ҳ�Ƕ���
���������е�class�ļ�������һ�𣬾���һ���ࣺ java.lang.Class

*/

public class AppTest {
	// ��ȡһ������ֽ��룺  �ֽ����Ǳ���javaԴ��������ģ���ô�ֽ����о�ӵ�ж�Դ����ġ����䡱��
	// ���ǻ�ȡ������ֽ���֮�󣬾���ͨ������ֽ��뷴������ȡ���еģ��ֶΡ���������������
	@Test
	public void test() throws Exception {
//		// 1. �Ƽ���ʽ�� ���ַ�ʽ����Ҫ����Person����  ��������ļ���
//		Class clazz = Class.forName("com.woniuxy.b_reflect.Person");
//		// 2. ��������ļ���
//		Class clazz2 = new Person().getClass();
//		// 3. ����������ļ���
//		Class clazz3 = Person.class;
//		
//		System.out.println(clazz == clazz2);
//		System.out.println(clazz == clazz3);
	}
	
	
	// ���÷�����ƣ����ʵ������Ķ���
	@Test
	public void test2() throws Exception {
//		Class clazz = Class.forName("com.woniuxy.b_reflect.Person");
//		
//		clazz.newInstance();
		
		// public Person()
//		Constructor c = clazz.getDeclaredConstructor();
//		Object obj = c.newInstance();
		
		// public Person(Integer id, String name) 
//		Constructor c2 = clazz.getDeclaredConstructor(Integer.class, String.class);
//		Object obj2 = c2.newInstance(1,"aa");
		
//		System.out.println(obj);
//		System.out.println(obj2);
		
//		Constructor[] cs = clazz.getDeclaredConstructors();
//		for (Constructor c : cs) {
//			System.out.println("==============================================");
//			System.out.print(Modifier.toString(c.getModifiers()) + " ");
//			System.out.println(c.getName());
//			Class[] parameterTypes = c.getParameterTypes();
//			System.out.println(Arrays.toString(parameterTypes));
//		}
		
		
	}

	// ��������ֶ�
	@Test
	public void test3() throws Exception {
//		Class clazz = Class.forName("com.woniuxy.b_reflect.Person");
//
//		Object obj = clazz.newInstance();
		
//		// private Integer id;
//		Field id = clazz.getDeclaredField("id");
//		// private Integer name;
//		Field name = clazz.getDeclaredField("name");
//		// public static String ss = "��ѩ"; 
//		Field ss = clazz.getDeclaredField("ss");
//		
//		
//		// ��id�ֶ� ���� obj��������ԣ� ��ֵΪ100
//		id.setAccessible(true);
//		id.set(obj, 100);
//		// ��name�ֶ� ����obj��������ԣ���ֵΪ���޼�
//		name.setAccessible(true);
//		name.set(obj, "���޼�");
//		System.out.println(id.get(obj));
//		System.out.println(name.get(obj));
//		System.out.println(ss.get(obj));
//		System.out.println(ss.get(null));
		
//		Field[] fields = clazz.getDeclaredFields();
//		
//		for (Field f : fields) {
//			System.out.println("=======================================");
//			f.setAccessible(true);
//			System.out.println(f.getModifiers() + ":" + Modifier.toString(f.getModifiers()));
//			System.out.println(f.getType());
//			System.out.println(f.getName());
//		}
	}

	@Test
	public void test4() throws Exception {
		Class clazz = Class.forName("com.woniuxy.b_reflect.Person");
		Object obj = clazz.newInstance();
		
//		// public void eat() 
//		Method eat = clazz.getMethod("eat");
//		// ��eat��������obj����ķ������е���
//		eat.invoke(obj);
//		
//		// public void eat(String food) 
//		Method eat2 = clazz.getMethod("eat", String.class);
//		eat2.invoke(obj,"��Ƥ");
//		
//		// public static void run()
//		Method run = clazz.getDeclaredMethod("run");
//		run.invoke(null);
//	
//		// public int add(int a, int b)
//		Method add = clazz.getDeclaredMethod("add", int.class, int.class);
//		Object r = add.invoke(obj, 2,3);
//		System.out.println(r);
//		
//		// public Class[] f1(Date[][][][][] dates, String str, Person p) 
//		Method f1 = clazz.getDeclaredMethod("f1", Date[][][][][].class, String.class, Person.class);
//		Class[] cc = (Class[]) f1.invoke(obj, new Date[][][][][] {}, new String(), new Person());
//		System.out.println(cc);
		
//		Method[] methods = clazz.getDeclaredMethods();
//		for (Method m : methods) {
//			m.setAccessible(true);
//			System.out.println("===================================================");
//			System.out.println(Modifier.toString(m.getModifiers()));
//			System.out.println(m.getReturnType());
//			System.out.println(m.getName());
//		}
		
		
		
	}
}
