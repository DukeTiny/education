package com.woniu.tank.bean;

import java.awt.Graphics;

public abstract class Element {
	int x; //元素的横坐标
	int y; //元素的纵坐标
	int width;	//元素的宽度
	int height; //元素的高度
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}



	abstract void draw(Graphics g);
	
}
