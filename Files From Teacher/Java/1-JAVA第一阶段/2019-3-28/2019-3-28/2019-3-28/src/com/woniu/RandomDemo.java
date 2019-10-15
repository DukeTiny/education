package com.woniu.demo;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		int i = (int)(Math.random()*10);
		System.out.println(i);
		
		Random rand = new Random();
		int j = rand.nextInt(101);
		Random rand2 = new Random();
		int j2 = rand2.nextInt();
		System.out.println(j);
		System.out.println(j2);
	}

}
