package com.woniu.demo;

public class StringDemo1 {

	public static void main(String[] args) {
		//声明字符串对象
//		String str = new String("你是傻子,你就是傻子");
		//替换字符串 replace();
//		str = str.replace("傻子", "**");
//		System.out.println(str);
		//获得字符串的长度
//		int len = str.length();
//		System.out.println(len);
		
		//截取字符串 substring
//		String temp = str.substring(5);
//		System.out.println(temp);
		
//		String temp = str.substring(5, 8);
//		System.out.println(temp);
		
		//indexOf()
		//我们有一个字符串，查找a出现的次数。
		String str = "sasafdjaisafwqa";
		int count = 0 ;
		int index = 0;
		
		while(str.indexOf("a",index)!=-1){
			count++;
			index=str.indexOf("a", index);
			index = index + 1;
		}
		System.out.println(count);
	}

}
