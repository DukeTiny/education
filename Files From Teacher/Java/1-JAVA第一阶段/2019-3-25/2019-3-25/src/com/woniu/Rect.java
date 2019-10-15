package com.woniu.demo3.d1;

public class Rect {
//	1、定义长方形类，含：
//
//	  属性：宽、高（整型）；
	private int width;
	private int height;
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
	
//	  方法：求周长、面积；
	public int getArea(){
		return this.width*this.height;
	}
	public int getLength(){
		return (this.width+this.height)*2;
	}
//	  构造方法3个：（1）无参——宽、高默认值为1；（2）1个参数——宽、高均为参数值；（3）2个参数——宽、高各为参数值。
	public Rect(){
		this.width = 1;
		this.height = 1;
	}
	public Rect(int n){
		this.width = n;
		this.height = n;
	}
	public Rect(int w,int h){
		this.width = w;
		this.height = h;
	}
}
