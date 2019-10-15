package com.woniu.demo;

import java.math.BigInteger;

public class BigIntegerDemo {

	public static void main(String[] args) {
		BigInteger bi1 = new BigInteger("1111111111111111111111111");
		BigInteger bi2 = new BigInteger("2");
		System.out.println(bi1.divide(bi2));
	}

}
