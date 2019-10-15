package com.woniuxy.b_reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

import org.junit.Test;

/*
 反射机制是什么？
 在java程序运行时，能获取到类的字段、方法、构造器的信息。

反射机制是干什么的？
就是用来做框架的！

我们知道，java源文件，编译之后都会得到字节码文件，又因为，世间万物皆对象，所以class文件也是对象
世界上所有的class文件集合在一起，就是一个类： java.lang.Class

*/

public class AppTest {
	// 获取一个类的字节码：  字节码是编译java源代码得来的，那么字节码中就拥有对源代码的“记忆”！
	// 我们获取了类的字节码之后，就能通过这个字节码反过来获取类中的：字段、方法、构造器。
	@Test
	public void test() throws Exception {
//		// 1. 推荐方式。 这种方式不需要引入Person的类  会引起类的加载
//		Class clazz = Class.forName("com.woniuxy.b_reflect.Person");
//		// 2. 会引起类的加载
//		Class clazz2 = new Person().getClass();
//		// 3. 不会引起类的加载
//		Class clazz3 = Person.class;
//		
//		System.out.println(clazz == clazz2);
//		System.out.println(clazz == clazz3);
	}
	
	
	// 利用反射机制，如何实例化类的对象
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

	// 反射类的字段
	@Test
	public void test3() throws Exception {
//		Class clazz = Class.forName("com.woniuxy.b_reflect.Person");
//
//		Object obj = clazz.newInstance();
		
//		// private Integer id;
//		Field id = clazz.getDeclaredField("id");
//		// private Integer name;
//		Field name = clazz.getDeclaredField("name");
//		// public static String ss = "飞雪"; 
//		Field ss = clazz.getDeclaredField("ss");
//		
//		
//		// 把id字段 当做 obj对象的属性， 赋值为100
//		id.setAccessible(true);
//		id.set(obj, 100);
//		// 把name字段 当做obj对象的属性，赋值为张无忌
//		name.setAccessible(true);
//		name.set(obj, "张无忌");
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
//		// 把eat方法当做obj对象的方法进行调用
//		eat.invoke(obj);
//		
//		// public void eat(String food) 
//		Method eat2 = clazz.getMethod("eat", String.class);
//		eat2.invoke(obj,"凉皮");
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
