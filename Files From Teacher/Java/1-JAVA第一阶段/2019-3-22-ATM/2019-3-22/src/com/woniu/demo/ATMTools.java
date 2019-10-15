package com.woniu.demo;

public class ATMTools {
	String[][] cards = new String[10][];
	int index = 0;
	public void reg(String cardId,String cardPwd,String name,String money){
		cards[index++] = new String[]{cardId,cardPwd,name,money};
	}
	public void showCard(String cardId){
		for(int i=0;i<index;i++){
			if(cardId.equals(cards[i][0])){
				System.out.print(cards[i][0]);
				System.out.print(cards[i][1]);
				System.out.print(cards[i][2]);
				System.out.print(cards[i][3]);
				break;
			}
		}
	}
}
