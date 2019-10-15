package com.woniu.exception;

public class MyException extends RuntimeException {
	public MyException(String message){
		super(message);
	}
	public void printStackTrace() {
		System.out.println("他是我仇人");
	}
	
}
