package com.woniu.demo;

public class DemoRun {

	public static void main(String[] args) {
		int n1 = 15;
		int n2 = 8;
		int n3 = 9;
		Demo d = new Demo();
		int[] ns = new int[]{123,44,234,53,800};
		int m = d.getMax(ns);
		System.out.println(m);
	}

}
