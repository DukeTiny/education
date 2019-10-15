package com.woniu.exception;

public class ExceptionDemo3 {
	public void show() throws Exception{
		System.out.println(1/0);
	}
	public static void main(String[] args) {
		ExceptionDemo3 ed = new ExceptionDemo3();
		try {
			ed.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
