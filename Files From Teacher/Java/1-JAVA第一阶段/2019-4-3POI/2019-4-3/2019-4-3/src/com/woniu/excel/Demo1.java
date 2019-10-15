package com.woniu.excel;

import com.woniu.tools.Tools;

public class Demo1 {

	public static void main(String[] args) {
		int num1 = 25;
		int num2 = 30;
		Tools tools = new Tools();
		int m = tools.max(num1, num2);
		System.out.println(m);

	}

}
