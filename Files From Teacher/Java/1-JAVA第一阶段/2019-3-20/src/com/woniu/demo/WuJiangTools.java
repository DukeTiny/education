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
		System.out.println("我方武将"+mine[mineRand]+"和敌方武将"+enemy[enemyRand]+"对战");
		System.out.println(isWin?"我方胜":"敌方胜");
			
	}
}
