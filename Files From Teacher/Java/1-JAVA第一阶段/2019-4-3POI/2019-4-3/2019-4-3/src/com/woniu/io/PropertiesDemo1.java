package com.woniu.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo1 {

	public static void main(String[] args) throws IOException {
		//读取配置文件的内容
		Properties pro = new Properties();
//		//载入输入流,将配置文件的内容存到map中
//		pro.load(PropertiesDemo1.class.getResourceAsStream("config.properties"));
//		//通过键获得map中的值  key=value
//		String value = pro.getProperty("filename");
//		System.out.println(value);
		
		//将key和value放入map中
		pro.setProperty("aaa", "ccc");
		//创建字节流或字符流
		FileOutputStream out = new FileOutputStream(PropertiesDemo1.class.getResource("config.properties").getPath());
		//将map中的值和注释写入配置文件。
		pro.store(out, "eee");
		
//		Set set = pro.keySet();
//		for(Object key:set){
//			Object value = pro.get(key);
//			System.out.println(key+":"+value);
//		}
	}

}
