package com.woniu.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileUtil {
	static File file;
	FileReader fr;
	BufferedReader br;
	static{
		Properties pro = new Properties();
		try {
			pro.load(FileUtil.class.getResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = pro.getProperty("filename");
		file = new File(str);
	}
	public FileUtil() throws IOException{
		
	}
	public List<Card> readFile() throws IOException{
		List<Card> cards = new ArrayList<Card>();
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		while(br.ready()){
			String cardStr = br.readLine();
			String[] cardInfo = cardStr.split(":");
			Card card = new Card(cardInfo[0],cardInfo[1],cardInfo[2],Integer.parseInt(cardInfo[3]));
			cards.add(card);
		}
		return cards;
	}
}
