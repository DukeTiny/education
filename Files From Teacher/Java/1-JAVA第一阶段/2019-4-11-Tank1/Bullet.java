package com.woniu.tank;

import java.awt.Graphics;
import java.awt.Image;

import javax.annotation.Resources;
import javax.swing.ImageIcon;

public class Bullet extends Thread {
	int x;
	int y;
	TankPanel tp;
	int d;
	Image bullet = new ImageIcon(Resources.class.getResource("/img/bullet.png")).getImage();
	public Bullet(int x,int y,TankPanel tp){
		this.x = x;
		this.y = y;
		this.tp = tp;
		this.d = tp.direction;
	}
	
	public void draw(Graphics g){
		g.drawImage(bullet, x*40, y*40,(x+1)*40,(y+1)*40,d*32,0,(d+1)*32,32, null);
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.d==0){
				y++;
			}else if(d==1){
				x++;
			}else if(d==2){
				y--;
			}else if(d==3){
				x--;
			}
			tp.repaint();
		}
	}
}
