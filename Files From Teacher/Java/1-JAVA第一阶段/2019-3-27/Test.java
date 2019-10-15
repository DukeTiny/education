package com.woniu.oop2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Iterator it2 = list.iterator();
//		while(it2.hasNext()){
//			System.out.println(it2.next());
//		}
		
		HashSet set = new HashSet();
		set.add(123);
		set.add("abc");
		set.add(123);
//		System.out.println(set.size());
//		//只能按照对象移除
//		set.remove(123);
//		System.out.println(set.size());
		//迭代器
		Iterator it = set.iterator();
		//迭代器是否还有值 hasNext();
		while(it.hasNext()){
			System.out.println(it.next());  //next()获取迭代器下一个值
		}
		
		//获得一个字符串，输出出现了哪些字符
		String str = "afj;safj;owaihaksfd";
		//声明一个HashSet对象，存入不重复的值
		HashSet set2 = new HashSet();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			//将每个字符添加到集合中
			set2.add(c);
		}
		//生成迭代器
		Iterator it3 = set2.iterator();
		//判断是否有值
		while(it3.hasNext()){
			//获取下一个值，并输出
			System.out.println(it3.next());
		}
	}

}
