package com.woniu.oop2;

public class People extends Monkey {

//	public People(){
//		System.out.println("子类");
//	}
	public People(String s){
		super(s);
		System.out.println("子类 有参");
	}
	public void speak(){
		System.out.println("小样的，不错嘛！会说话了！");
	}
	
	public void think(){
		System.out.println("别说话！认真思考！");
	}
}
