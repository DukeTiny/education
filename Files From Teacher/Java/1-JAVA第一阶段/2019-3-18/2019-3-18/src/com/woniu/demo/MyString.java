package com.woniu.demo;

public class MyString {
	public String replace(String str,String oldStr,String newStr){
		//str = "你是傻子,你就是傻子"
		//oldStr = "傻子"
		//newStr = "**"
		//找
		//截取
		//替换
		
//		String a = "你是";
//		String b = ",你就是傻子";
//		String c = a+"**"+b;
		
		//indexOf()
		int index = str.indexOf("傻子");
		String a = str.substring(0,index);
		String b = str.substring(index+oldStr.length());
		String temp = a+newStr+b;
		return temp;
	}
}
