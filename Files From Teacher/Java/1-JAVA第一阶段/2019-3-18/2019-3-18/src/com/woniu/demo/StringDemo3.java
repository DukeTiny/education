package com.woniu.demo;

public class StringDemo3 {

	public static void main(String[] args) {
		//模拟一个toCharArray()的功能
		//将字符串转换成字符数组
		//charAt();根据下标获取字符串中对应的字符
		String str = "abcde";
		//声明一个字符数组，长度为字符串长度
		char[] cs = new char[str.length()];
		//循环获得字符串中每个字符
		for(int i=0;i<cs.length;i++){
			char c = str.charAt(i);
			//逐个放入数组中
			cs[i] = c;
		}
		
	}

}
