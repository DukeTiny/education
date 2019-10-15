package com.woniu.demo;

public class StringDemo4 {

	public static void main(String[] args) {
		String str = "abCdE";
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
		//先将字符串转为字节数组
		byte[] bs = str.getBytes();
		//循环遍历每个字节
		for(int i=0;i<bs.length;i++){
//			//判断该字节是否为小写字母
//			if(bs[i]>=97&&bs[i]<=122){
//				//如果为小写字母，将码值转为大写。
//				bs[i] = (byte) (bs[i]-32);
//			}
			if(bs[i]>=65&&bs[i]<=90){
				//如果为小写字母，将码值转为大写。
				bs[i] = (byte) (bs[i]+32);
			}
		}
		for(byte b:bs){
			System.out.print((char)b);
		}	
	}

}
