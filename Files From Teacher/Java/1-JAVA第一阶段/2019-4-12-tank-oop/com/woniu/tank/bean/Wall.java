package com.woniu.tank.bean;

import java.awt.Graphics;
import java.awt.Image;

import com.woniu.tank.util.Resource;

public class Wall extends Element {
	int type = 1;

	public Wall(int type) {
		this.type = type;
	}

	public void draw(Graphics g) {
		Image img = null;
		switch (this.type) {
		case 1:
			img = Resource.grass;
			break;
		case 2:
			img = Resource.wall;
			break;
		case 3:
			img = Resource.steel;
			break;
		case 4:
			img = Resource.boss;
			break;

		}
		// 图片放入面板的位置
		int targetX = this.getX() * this.getWidth();
		int targetY = this.getY() * this.getHeight();
		
		g.drawImage(img, targetX, targetY, this.getWidth(), this.getHeight(), null);

	}

}
