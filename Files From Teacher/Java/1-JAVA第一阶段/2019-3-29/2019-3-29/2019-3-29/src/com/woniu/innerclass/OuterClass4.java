package com.woniu.innerclass;

public class OuterClass4 {
	public void show(){
		new IEvent(){

			public void show1() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	public static void main(String[] args) {
		OuterClass4 outer = new OuterClass4();
		outer.show();
	}
}
