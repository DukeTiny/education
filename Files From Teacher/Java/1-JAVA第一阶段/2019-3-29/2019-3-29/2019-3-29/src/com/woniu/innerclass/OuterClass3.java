package com.woniu.innerclass;

public class OuterClass3 {
	private static int i;
	int j;
	protected int k;
	public int l;
	static class innerClass{
		public static void show(){
			i = 1;
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		OuterClass3.innerClass.show();
	}
}
