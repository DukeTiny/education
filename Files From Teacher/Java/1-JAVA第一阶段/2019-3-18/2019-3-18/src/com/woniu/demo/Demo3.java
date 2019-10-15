package com.woniu.demo;

import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		//1、获得一个英文字符串，将所有小写转大写。
		Scanner scan = new Scanner(System.in);
//		String str = scan.next();
//		str = str.toUpperCase();
//		System.out.println(str);
		//2、循环从键盘获得5个字符串，并输出这些字符串是否以abc开头。
//		for(int i=1;i<=5;i++){
//			System.out.print("请输入第"+i+"个数:");
//			String str = scan.next();
//			if(str.startsWith("abc")){
//				System.out.println(str+"是以abc开头");
//			}else{
//				System.out.println(str+"不是以abc开头");
//				
//			}
//		}
		//3、从键盘获得一个字符串，加密输出。
		String str = scan.next();
		char[] cs = str.toCharArray();
		for(int i=0;i<cs.length;i++){
			char c = cs[i];
			cs[i] = (char) (c+1);
		}
		String s = new String(cs);
		System.out.println(s);
//		4、编写程序将 “jdk” 全部变为大写,并输出到屏幕,截取子串”DK” 并输出到屏幕
//		toUpperCase();
//		substring();
//		5、编写程序将String类型字符串”hello” 变为 “olleh”.
		
//		6、去掉一个字符串中空格。
//		replace()
//		7、输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
//		toCharArray();
//		8、一个子串在整串中出现的次数。
//		indexOf();
	}

}
