package com.woniu.demo;

public class Demo2 {

	public static void main(String[] args) {
		//String的方法
		//int length();获取字符串的长度
		//String substrig();截取字符串
		//String replace();替换字符串
		//toCharArray();
		//getBytes();
		//charAt();
		//toUpperCase();
		//toLowerCase();
		//indexOf();
		//lastIndexOf();
		//startsWith();
		//endsWith();

		String str = "abc";
		String str2 = new String("Abc");
		boolean flag = str.equals(str2);
		boolean flag2 = str.equalsIgnoreCase(str2);
		System.out.println(flag);
	}

}
