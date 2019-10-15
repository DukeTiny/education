package com.woniu.demo;

import com.woniu.bean.Card;
import com.woniu.dao.ATMTools;

public class Test {

	public static void main(String[] args) {
		String cid = "1001";
		String pwd = "123";
		String n = "Andy";
		int m = 1000;
		
		Card card = new Card();
		card.cardID = cid;
		card.cardPwd = pwd;
		card.name = n;
		card.money = m;
		
		String cid2 = "1002";
		String pwd2 = "321";
		String n2 = "Jack";
		int m2 = 100;
		
		Card card2 = new Card();
		card2.cardID = cid2;
		card2.cardPwd = pwd2;
		card2.name = n2;
		card2.money = m2;
		
		ATMTools atmTools = new ATMTools();
		atmTools.addCard(card);
		atmTools.addCard(card2);
		
		atmTools.showCards();
		
		String cid3 = "1002";
		String pwd3 = "321";
		boolean flag = atmTools.login(cid3, pwd3);
		if(flag){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
		
		int m3 = 10000;
		atmTools.saveMoney(m3);
		atmTools.showCards();
		
		int m4 = 5000;
		boolean flag2 = atmTools.getMoney(m4);
		if(flag2){
			System.out.println("取款成功");
		}else{
			System.out.println("取款失败");
		}
		atmTools.showCards();
		
		String cid4 = "1001";
		int m5 = 1500;
		String message = atmTools.transMoney(cid4, m5);
		System.out.println(message);
		atmTools.showCards();
	}

}
