package com.woniu.tank.bean;

import java.awt.Graphics;

import com.woniu.tank.ui.TankPanel;
import com.woniu.tank.util.Resource;

public class Player extends Element {
	int direction = 2;
	TankPanel tp;
	public TankPanel getTp() {
		return tp;
	}
	public void setTp(TankPanel tp) {
		this.tp = tp;
	}
	public Player(TankPanel tp,int x,int y){
		this.tp = tp;
		this.x = x;
		this.y = y;

	}
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void draw(Graphics g) {
		//图片放入面板的位置
		int targetX =  this.getX()*this.getWidth();
		int targetX1 = (this.getX()+1)*this.getWidth();
		int targetY =  this.getY()*this.getHeight();
		int targetY1 = (this.getY()+1)*this.getHeight();
		
		//截取源图的位置
		//0,0,32,32
		//0,32,32,64
		//0,64,32,96
		//0,96,32,128
		int sourceX =  0;
		int sourceX1 = 32;
		int sourceY =  this.getDirection()*32;
		int sourceY1 = (this.getDirection()+1)*32;
		g.drawImage(Resource.player,targetX,targetY,targetX1,targetY1,sourceX,sourceY,sourceX1,sourceY1, null);
	}

}
