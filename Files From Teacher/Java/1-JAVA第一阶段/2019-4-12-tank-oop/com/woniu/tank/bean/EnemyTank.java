package com.woniu.tank.bean;

import java.awt.Graphics;

import com.woniu.tank.ui.TankPanel;
import com.woniu.tank.util.Resource;

public class EnemyTank extends Element implements Runnable {

	int direction = 0;
	TankPanel tp;
	public EnemyTank(TankPanel tp,int x,int y){
		this.tp = tp;
		this.x = x;
		this.y = y;
		Thread th = new Thread(this);
		th.start();
	}
	
	public void run() {
		while(true){
			move();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tp.repaint();
		}

	}
	int count = 0;
	public void move(){
		if(count==5){
			direction = (int)(Math.random()*4);
			count = 0;
		}
		count++;
		int x = this.getX();
		int y = this.getY();
		switch(direction){
			case 0:
				if(y+1<TankPanel.level.length&&TankPanel.level[y+1][x]<2){
					this.setY(y+1);
				}
				break;
			case 1:
				if(x-1>=0&&TankPanel.level[y][x-1]<2){
					this.setX(x-1);		
				}
				break;
			case 2:
				if(x+1<TankPanel.level[0].length&&TankPanel.level[y][x+1]<2){
					this.setX(x+1);
				}
				break;
			case 3:
				if(y-1>=0&&TankPanel.level[y-1][x]<2){
					this.setY(y-1);
				}
				break;
		}
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public TankPanel getTp() {
		return tp;
	}

	public void setTp(TankPanel tp) {
		this.tp = tp;
	}

	public void draw(Graphics g) {
		// 图片放入面板的位置
		int targetX = this.getX() * this.getWidth();
		int targetX1 = (this.getX() + 1) * this.getWidth();
		int targetY = this.getY() * this.getHeight();
		int targetY1 = (this.getY() + 1) * this.getHeight();

		// 截取源图的位置  //下0 左1 右2 上3
		// 0,0,32,32
		// 0,32,32,64
		// 0,64,32,96
		// 0,96,32,128
		int sourceX = 0;
		int sourceX1 = 32;
		int sourceY = this.getDirection() * 32;
		int sourceY1 = (this.getDirection() + 1) * 32;
		g.drawImage(Resource.enemy, targetX, targetY, targetX1, targetY1, sourceX, sourceY, sourceX1, sourceY1, null);

	}

}
