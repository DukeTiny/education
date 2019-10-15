package com.woniu.atm.ui;

import java.util.ArrayList;

import com.woniu.atm.bean.Card;
import com.woniu.atm.dao.ATMTools;

public class ATM {

	public static void main(String[] args) {
		ATMTools atmTools = new ATMTools();

		Card card = new Card("1001","123","Andy",1000);
		Card card1 = new Card();
		card1.setCid("1002");
		card1.setCpwd("321");
		card1.setCname("Jack");
		card1.setCmoney(100);
		atmTools.addCard(card);
		atmTools.addCard(card1);

		String cid = "1001";
		String cpwd = "123";
		Card loginCard = new Card();
		loginCard.setCid(cid);
		loginCard.setCpwd(cpwd);
		loginCard = atmTools.login(loginCard);


		int money = 500;
		loginCard.setCmoney(loginCard.getCmoney()+money);
		atmTools.update(loginCard);
		
		ArrayList<Card> cards = atmTools.getAllCards();
		for(int i=0;i<cards.size();i++){
			Card c = cards.get(i);
			System.out.println ( c.getCid()+":"+c.getCpwd()+":"+c.getCname()+":"+c.getCmoney());
		}
		
		int money2 = -200;
		loginCard.setCmoney(loginCard.getCmoney()+money2);
		atmTools.update(loginCard);
		
		cards = atmTools.getAllCards();
		for(int i=0;i<cards.size();i++){
			Card c = cards.get(i);
			System.out.println(c.getCid()+":"+c.getCpwd()+":"+c.getCname()+":"+c.getCmoney());
		}
		//��һ�ſ���200Ԫת����ſ�
		int money3 = 200;
		String cid2 = "1002";
		if(loginCard.getCmoney()>=money3){
			loginCard.setCmoney(loginCard.getCmoney()-money3);
			atmTools.update(loginCard);
			Card c = atmTools.getCardByCid(cid2);
			c.setCmoney(c.getCmoney()+money3);
			atmTools.update(c);
		}
		
		cards = atmTools.getAllCards();
		for(int i=0;i<cards.size();i++){
			Card c = cards.get(i);
			System.out.println(c.getCid()+":"+c.getCpwd()+":"+c.getCname()+":"+c.getCmoney());
		}

	}

}
