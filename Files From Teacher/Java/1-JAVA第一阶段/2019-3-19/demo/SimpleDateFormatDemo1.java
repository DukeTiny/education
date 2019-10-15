package com.woniu.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo1 {

	public static void main(String[] args) throws ParseException {
		//SimpleDateFormat
		Date d = new Date();
		System.out.println(d);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		String str = sdf.format(d);
		System.out.println(str);
		
		String dateStr = "2019:05:02";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy:MM:dd");
		Date d2 = sdf2.parse(dateStr);
		System.out.println(d2);
	}

}
