package com.woniu.demo;

public class WuJiangTools {
	String[] mine = new String[5];
	int mineIndex = 0;
	String[] enemy = new String[5];
	int enemyIndex = 0;
	public void addMyWuJiang(String name){
		mine[mineIndex++] = name;
	}
	public void addDiWuJiang(String name){
		enemy[enemyIndex++] = name;
	}
	public void pk(){
		int mineRand = (int)(Math.random()*5);
		int enemyRand = (int)(Math.random()*5);
		boolean isWin = (int)(Math.random()*2)==0?true:false;
		System.out.println("�ҷ��佫"+mine[mineRand]+"�͵з��佫"+enemy[enemyRand]+"��ս");
		System.out.println(isWin?"�ҷ�ʤ":"�з�ʤ");
			
	}
}
