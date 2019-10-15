package com.woniu.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * ��һ�������ļ������ݷ��õ�map��
 * ͨ��getConfig(String key)������ȡ��������
 * @author Administrator
 *
 */
public class Tools {
	Map<String,String> map = new HashMap<String,String>();
	File file = new File("config.txt");
	public Tools() throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()){
			String str = br.readLine();
			String[] strInfo = str.split("=");
			map.put(strInfo[0], strInfo[1]);
		}
		br.close();
		fr.close();
	}
	
	public String getConfig(String key){
		return map.get(key);
	}
}
