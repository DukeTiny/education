package com.woniu.demo3.d1;

public class Area {
//	����һ����̬����PI=3.1415926��
	public static final float PI = 3.1415926f;
//			����һ����̬�����뾶float r��
	static float r;
//			����һ��Ϊ�չ��췽����
	public Area(){
		
	}
//			����һ�����εĹ��췽�������һ��float���͵İ뾶�����������ò�������r��
	public Area(float r){
		this.r = r;
	}
//			����һ��ʵ������getArea(),��ø����뾶r��Բ�����
	public float getArea(){
		return PI*r*r;
	}
}
