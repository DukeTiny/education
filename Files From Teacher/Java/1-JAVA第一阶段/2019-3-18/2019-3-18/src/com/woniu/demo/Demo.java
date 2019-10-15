package com.woniu.demo;

public class Demo {

	public static void main(String[] args) {
		//我们有一个字符串，查找a出现的次数。
		//String indexOf(String targetStr,int fromIndex);
		//找到targetStr在原串中从fromIndex开始第一次出现的位置。
		String str = "erewafsadfasfwe";
		int count = 0;
		//每次找到a的位置
		int index = 0;
		//开始查找的位置
		int fromIndex = 0;
		while(str.indexOf("a",fromIndex)!=-1){
			count++;
			index = str.indexOf("a",fromIndex);
			fromIndex = index + 1;
		}
		System.out.println(count);
	}

}
