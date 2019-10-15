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
	 * ע��
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
	 * ��¼
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
	 * ȡǮ
	 * @param card
	 */
	public boolean getMoney(Card card){
		boolean flag = false;
		try {
			//������п�����Ϣ
			List<Card> cards = fm.readFile();
			for(Card c:cards){
				//�ҵ���ǰ��¼������Ϣ
				if(c.getCno().equals(nowCard.getCno())){
					//�ж�����Ƿ��㹻
					if(c.getCmoney()>=card.getCmoney()){
						//�������ж�Ӧ�Ľ������޸�
						c.setCmoney(c.getCmoney()-card.getCmoney());
						//��־�������޸�
						flag = true;
						break;
					}
				}
			}
			//�����Ƿ��޸�
			if(flag){
				//��Դ�ļ��������
				fm.writeFile(null, false);
				//ѭ�������е�card��������׷�ӵ��ļ���
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
	 * ��ȡһ��������
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
