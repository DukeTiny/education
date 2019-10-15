package com.woniu.atm.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.atm.bean.Card;
import com.woniu.util.FileManage;

public class ATMTools {
	FileManage fm = new FileManage();
	public static final String SPLIT_CHAR = ":";
	Card nowCard;
	/**
	 * 注册
	 * @param card
	 */
	public void save(Card card) {
		try {
			fm.writeFile(card,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			fm.closeWriter();
		}
	}
	/**
	 * 登录
	 * @param card
	 * @return
	 */
	public Card login(Card card){
		Card loginCard = this.getCard(card.getCno());
		if(loginCard!=null){
			if(loginCard.getCpwd().equals(card.getCpwd())){
				nowCard = loginCard;
				return loginCard;
			}
		}
		return null;
	}
	/**
	 * 取钱
	 * @param card
	 */
	public boolean getMoney(Card card){
		boolean flag = false;
		try {
			//获得所有卡的信息
			List<Card> cards = fm.readFile();
			for(Card c:cards){
				//找到当前登录卡的信息
				if(c.getCno().equals(nowCard.getCno())){
					//判断余额是否足够
					if(c.getCmoney()>=card.getCmoney()){
						//将集合中对应的金额进行修改
						c.setCmoney(c.getCmoney()-card.getCmoney());
						//标志集合已修改
						flag = true;
						break;
					}
				}
			}
			//集合是否修改
			if(flag){
				//将源文件内容清空
				fm.writeFile(null, false);
				//循环集合中的card对象，依次追加到文件中
				for(Card c:cards){
					fm.writeFile(c, true);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fm.closeReader();
			fm.closeWriter();
		}
		
		return flag;
	}
	public void setMoney(Card card){
		
	}
	public void turnMoney(String myCno,String otherCno,int money){
		
	}
	
	public void delete(String cno){
		
	}
	/**
	 * 获取一个卡对象
	 * @param cno
	 * @return
	 */
	public Card getCard(String cno){
		try {
			List<Card> cards = fm.readFile();
			for(Card c:cards){
				if(c.getCno().equals(cno)){
					return c;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fm.closeReader();
		}
		return null;
	}
	public List<Card> getAllCards(){
		List<Card> cards = new ArrayList<Card>();
		try {
			cards = fm.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fm.closeReader();
		}
		
		return cards;
	}
}
