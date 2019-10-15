package com.woniu.innerclass;

public class OuterClass {
	private int i;
	int j;
	protected int k;
	public int l;
	
	class InnerClass{
		public void show(){
			i = 1;
			j = 2;
			k = 3;
			l = 4;
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		OuterClass.InnerClass inner = new OuterClass().new InnerClass();
		inner.show();
	}
}

