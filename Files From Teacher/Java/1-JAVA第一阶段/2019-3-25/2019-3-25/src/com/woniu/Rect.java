package com.woniu.demo3.d1;

public class Rect {
//	1�����峤�����࣬����
//
//	  ���ԣ����ߣ����ͣ���
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
	
//	  ���������ܳ��������
	public int getArea(){
		return this.width*this.height;
	}
	public int getLength(){
		return (this.width+this.height)*2;
	}
//	  ���췽��3������1���޲Ρ�������Ĭ��ֵΪ1����2��1�������������߾�Ϊ����ֵ����3��2�������������߸�Ϊ����ֵ��
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
