package com.woniu.atm.dao;

import java.util.ArrayList;

import com.woniu.atm.bean.Card;

public class ATMTools {

	ArrayList<Card> cards = new ArrayList<Card>();

	Card nowCard;

	public void addCard(Card card){
		this.cards.add(card);
	}

	public Card login(Card loginCard){
		for(int i=0;i<cards.size();i++){
			Card c = cards.get(i);
			if(c.getCid().equals(loginCard.getCid())&&c.getCpwd().equals(loginCard.getCpwd())){
				nowCard = c;
				return c;
			}
		}
		return null;
	}

	public void update(Card card){
		nowCard = card;
	}

	public Card getCardByCid(String cid){
		for(int i=0;i<cards.size();i++){
			Card c = cards.get(i);
			if(c.getCid().equals(cid)){
				return c;
			}
		}
		return null;
	}

	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
