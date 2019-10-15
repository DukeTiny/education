package com.woniu.dao;

import com.woniu.bean.Card;

public class ATMTools {
	Card[] cards = new Card[10];
	int index = 0;
	Card loginCard;
	public void addCard(Card card){
		cards[index++] = card;
	}
	
	public void showCards(){
		for(int i=0;i<index;i++){
			Card c = cards[i];
			System.out.println(c.cardID+":"+c.cardPwd+":"+c.name+":"+c.money);
		}
	}
	
	public boolean login(String cardID,String cardPwd){
		for(int i=0;i<index;i++){
			Card c = cards[i];
			if(c.cardID.equals(cardID)&&c.cardPwd.equals(cardPwd)){
				loginCard = c;
				return true;
			}
		}
		return false;
	}

	public void saveMoney(int m3) {
		loginCard.money += m3;
	}
	
	public boolean getMoney(int m3) {
		if(loginCard.money>=m3){
			loginCard.money -= m3;
			return true;
		}
		return false;
	}
	
	public String transMoney(String cid,int money){
		for(int i=0;i<index;i++){
			Card c = cards[i];
			if(c.cardID.equals(cid)){
				if(loginCard.money>=money){
					loginCard.money-=money;
					c.money+=money;
					return "ok";
				}else{
					return "余额不足！";
				}
			}
		}
		return "对方卡号不存在";
	}
	
}
