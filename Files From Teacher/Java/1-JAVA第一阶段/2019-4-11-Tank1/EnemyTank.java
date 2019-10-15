package com.woniu.tank;

import java.awt.Graphics;
import java.awt.Image;

import javax.annotation.Resources;
import javax.swing.ImageIcon;

public class EnemyTank extends Thread {
	int x;
	int y;
	Image enemy = new ImageIcon(Resources.class.getResource("/img/enemy.png")).getImage();
	
	TankPanel tp;
	
	public EnemyTank(int x,int y,TankPanel tp){
		this.x = x;
		this.y = y;
		this.tp = tp;
	}
	
	public void draw(Graphics g){
		g.drawImage(enemy, x*40, y*40,(x+1)*40,(y+1)*40,0,0,32,32, null);
	}
	
	public void run() {
		boolean flag = true;
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(x==18){
				flag = false;
			}else if(x==0){
				flag = true;
			}
			if(flag){
				x++;
			}else{
				x--;
			}
			tp.repaint();
		}
	}
	
}
