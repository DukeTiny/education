package com.woniu.demo3.d1;

public class Area {
//	声明一个静态常量PI=3.1415926。
	public static final float PI = 3.1415926f;
//			声明一个静态变量半径float r。
	static float r;
//			声明一个为空构造方法。
	public Area(){
		
	}
//			声明一个带参的构造方法，获得一个float类型的半径参数，并将该参数赋给r。
	public Area(float r){
		this.r = r;
	}
//			声明一个实例方法getArea(),获得给定半径r的圆面积。
	public float getArea(){
		return PI*r*r;
	}
}
