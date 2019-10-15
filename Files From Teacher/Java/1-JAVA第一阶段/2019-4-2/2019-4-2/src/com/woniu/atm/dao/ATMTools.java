package com.woniu.atm.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.woniu.atm.bean.Card;

public class ATMTools {
	File file = new File("d:/cards.txt");
	PrintWriter pw;
	BufferedReader br;
	FileReader in;
	final String SPLIT_CHAR = ":";
	public void save(Card card) {
		try {
			pw = new PrintWriter(file);
			String str = card.toString();
			pw.println(str);
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			pw.close();
		}
	}
	public Card login(Card card){
		try {
			in = new FileReader(file);
			br = new BufferedReader(in);
			while(br.ready()){
				//1001:123:王二狗:1000
				String cardStr = br.readLine();
				//{"1001","123","王二狗","1000"}
				String[] cardInfo = cardStr.split(this.SPLIT_CHAR);
				//获取每个卡的信息，与用户输入的卡号和密码进行比对
				if(cardInfo[0].equals(card.getCno())&&cardInfo[1].equals(card.getCpwd())){
					card.setCname(cardInfo[2]);
					card.setCmoney(Integer.parseInt(cardInfo[3]));
					return card;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				br.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public void getMoney(Card card){
		
	}
	public void setMoney(Card card){
		
	}
	public void turnMoney(String myCno,String otherCno,int money){
		
	}
	
	public void delete(String cno){
		
	}
	public Card getCard(String cno){
		return null;
	}
	public ArrayList<Card> getAllCards(){
		return null;
	}
}
