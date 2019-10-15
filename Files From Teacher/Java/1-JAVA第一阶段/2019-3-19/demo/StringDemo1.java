package com.woniu.demo;

public class StringDemo1 {

	public static void main(String[] args) {
		String str = "abc";
		String str2 = new String("abc");
		byte[] bs = new byte[10];
		String str3 = new String(bs);
		char[] cs = new char[10];
		String str4 = new String(cs);
		
		//获得字符串长度
		int len = str.length();
		System.out.println(len);
		//字符串内容比较
		boolean flag = str.equals(str2);
		boolean flag5 = str.equalsIgnoreCase(str2);
		System.out.println(flag);
		//比较地址
		boolean flag2 = str==str2;
		System.out.println(flag2);
		//获得字符数组
		char[] cs2 = str.toCharArray();
		//获得字节数组
		byte[] bs2 = str.getBytes();
		//获得子串在原串中第一次出现的位置
		int index = str.indexOf("bc");
		//获得子串在原串中最后一次出现的位置
		int endIndex = str.lastIndexOf("bc");
		//判断原串是否以子串开始
		boolean flag3 = str.startsWith("ab");
		//判断原串是否以子串结束
		boolean flag4 = str.endsWith("bb");
		//替换字符串
		str = str.replace("a", "z");
		//截取字符串
		String temp = str.substring(1);
		//转大写
		String temp1 = str.toUpperCase();
		//转小写
		String temp2 = str.toLowerCase();
		//根据下标获取指定的字符
		char c = str.charAt(0);
	}

}
