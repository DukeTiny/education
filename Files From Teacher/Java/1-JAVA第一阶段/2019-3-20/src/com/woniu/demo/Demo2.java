package com.woniu.demo;

public class Demo2 {
	String[][] poker = new String[4][13];
	/**
	 * ÂòÅÆ
	 * @return
	 */
	public String[][] buyPoker() {
		for(int i=0;i<13;i++){
			poker[0][i]="ºÚÌÒ"+(i+1);
			poker[1][i]="ºìÌÒ"+(i+1);
			poker[2][i]="Ã·»¨"+(i+1);
			poker[3][i]="·½¿é"+(i+1);
		}
		return poker;
	}
	
	/**
	 * ÏÔÊ¾ÅÆ
	 * @param poker
	 */
	public void showPoker(String[][] poker){
		for(int i=0;i<poker.length;i++){
			for(int j=0;j<poker[i].length;j++){
				System.out.print(poker[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Ï´ÅÆ
	 */
	public String[][] washPoker() {
		for(int i=0;i<100;i++){
			int x1 = (int)(Math.random()*4);
			int x2 = (int)(Math.random()*4);
			int y1 = (int)(Math.random()*13);
			int y2 = (int)(Math.random()*13);
			String temp = poker[x1][y1];
			poker[x1][y1] = poker[x2][y2];
			poker[x2][y2] = temp;
		}
		return poker;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo2 d2 = new Demo2();
		String[][] p = d2.buyPoker();
		d2.showPoker(p);
		p = d2.washPoker();
		System.out.println("---------------------------------------");
		d2.showPoker(p);
	}


	

}
