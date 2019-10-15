package com.woniu.demo;

import java.util.Date;

public class DateDemo1 {

	public static void main(String[] args) {
		//日期类
		//获得当前日期
		Date date = new Date();
		
		//自定义日期
//		Date date = new Date(119, 2, 19);
		
//		Date date = new Date(119,2,19,16,30,30);
		
		int year = date.getYear();
		int month = date.getMonth();
		int d = date.getDate();
		int day = date.getDay();
		int hours = date.getHours();
		int minutes = date.getMinutes();
		int seconds = date.getSeconds();
		long time = date.getTime();
		System.out.println(year);
		System.out.println(month);
		System.out.println(d);
		System.out.println(day);
		System.out.println(hours);
		System.out.println(minutes);
		System.out.println(seconds);
		System.out.println(time);
		
		
		

	}

}
