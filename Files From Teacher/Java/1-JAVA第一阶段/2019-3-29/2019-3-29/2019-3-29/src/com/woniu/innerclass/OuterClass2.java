package com.woniu.innerclass;

public class OuterClass2 {
	private int i;
	int j;
	protected int k;
	public int l;
	
	public void outerMethod(){
		
		class InnerClass{
			public void show(){
				i = 1;
				j = 2;
				k = 3;
				l = 4;
				System.out.println(i);
			}
		}
		InnerClass inner = new InnerClass();
		inner.show();
	}
	
	
	
	public static void main(String[] args) {
		OuterClass2 outer = new OuterClass2();
		outer.outerMethod();
	}
}

