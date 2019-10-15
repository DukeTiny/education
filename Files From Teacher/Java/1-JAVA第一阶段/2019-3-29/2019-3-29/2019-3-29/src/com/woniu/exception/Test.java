package com.woniu.exception;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		if(s.equals("梅超风")){
			try{
				throw new MyException("她不是一个好人");
			}catch(MyException e){
				
			}
		}

	}

}
