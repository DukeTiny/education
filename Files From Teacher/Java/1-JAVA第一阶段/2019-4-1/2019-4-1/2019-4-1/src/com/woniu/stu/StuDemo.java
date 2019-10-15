package com.woniu.stu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StuDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("f:/stu.txt");
		FileReader reader = new FileReader(f);
		char[] c = new char[(int) f.length()];
		reader.read(c);
		reader.close();
		String stusStr = new String(c);
		System.out.println(stusStr);
		
		//声明一个集合
		ArrayList<Stu> stus = new ArrayList<Stu>();
		//从字符串获取每个学生对象的字符串
		String[] strs = stusStr.split(";");
//		System.out.println(strs.length);
		for(String s:strs){
			if(!s.trim().equals("")){
				String[] str = s.split(":");
				Stu stu = new Stu();
				stu.setSid(str[0]);
				stu.setSname(str[1]);
				stu.setSage(Integer.parseInt(str[2]));
				stus.add(stu);
			}
		}
		for(Stu s:stus){
			System.out.println(s);
		}
	}

}
