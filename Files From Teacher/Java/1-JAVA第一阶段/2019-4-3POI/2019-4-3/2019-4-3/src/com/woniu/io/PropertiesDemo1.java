package com.woniu.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo1 {

	public static void main(String[] args) throws IOException {
		//��ȡ�����ļ�������
		Properties pro = new Properties();
//		//����������,�������ļ������ݴ浽map��
//		pro.load(PropertiesDemo1.class.getResourceAsStream("config.properties"));
//		//ͨ�������map�е�ֵ  key=value
//		String value = pro.getProperty("filename");
//		System.out.println(value);
		
		//��key��value����map��
		pro.setProperty("aaa", "ccc");
		//�����ֽ������ַ���
		FileOutputStream out = new FileOutputStream(PropertiesDemo1.class.getResource("config.properties").getPath());
		//��map�е�ֵ��ע��д�������ļ���
		pro.store(out, "eee");
		
//		Set set = pro.keySet();
//		for(Object key:set){
//			Object value = pro.get(key);
//			System.out.println(key+":"+value);
//		}
	}

}
