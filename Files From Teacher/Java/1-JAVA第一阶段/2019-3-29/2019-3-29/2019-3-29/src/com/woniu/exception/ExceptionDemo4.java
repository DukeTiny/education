package com.woniu.exception;

public class ExceptionDemo4 {

	public void show() throws Exception{
		if(true){
			throw new Exception("ฮาดํมห");
		}
	}
	
	public static void main(String[] args) {
		ExceptionDemo4 ed = new ExceptionDemo4();
		try{
			ed.show();
		}catch(Exception e){
			
		}finally{
			
		}

	}

}
