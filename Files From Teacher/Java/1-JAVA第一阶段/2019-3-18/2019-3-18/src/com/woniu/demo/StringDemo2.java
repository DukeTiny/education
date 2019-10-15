package com.woniu.demo;

//java.lang
public class StringDemo2 {

	public static void main(String[] args) {
		String str = "你好";
		//将字符串转成字符数组
//		char[] cs = str.toCharArray();
//		for(char c:cs){
//			System.out.println(c);
//		}
		//将字符串转成字节数组
		byte[] bs = str.getBytes();
		for(byte b:bs){
			System.out.println(b);
		}
	}

}
