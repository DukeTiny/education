package com.woniu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.woniu.atm.bean.Card;
import com.woniu.atm.dao.ATMTools;

public class FileManage {
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	PrintWriter pw;
	File file = new File("d:/cards.txt");
	/**
	 * 写文件，获得两个参数，第二参数为false将原文件内容去掉，为true追加写
	 * @param card
	 * @param flag
	 * @throws IOException
	 */
	public void writeFile(Card card,boolean flag) throws IOException{
		if(flag){
			fw = new FileWriter(file,true);
			pw = new PrintWriter(fw);
			pw.println(card.toString());
			pw.flush();
		}else{
			fw = new FileWriter(file,false);
			pw = new PrintWriter(fw);
			pw.print("");
			pw.flush();
		}
	}
	/**
	 * 读文件的方法，每读一行，封装成一个card对象，再将card对象添加到集合中
	 * @return
	 * @throws IOException
	 */
	public List<Card> readFile() throws IOException{
		List<Card> list = new ArrayList<Card>();
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		while(br.ready()){
			Card card = new Card();
			String cardStr = br.readLine();
			String[] cardInfo = cardStr.split(ATMTools.SPLIT_CHAR);
			card.setCno(cardInfo[0]);
			card.setCpwd(cardInfo[1]);
			card.setCname(cardInfo[2]);
			card.setCmoney(Integer.parseInt(cardInfo[3]));
			list.add(card);
		}
		return list;
	}
	
	public void closeReader(){
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeWriter(){
		try {
			fw.close();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
