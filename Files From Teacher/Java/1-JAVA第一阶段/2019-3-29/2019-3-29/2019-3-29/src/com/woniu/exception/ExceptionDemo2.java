package com.woniu.exception;

public class ExceptionDemo2 {
	public int show(){
		try{
			System.out.println(11111111);
			System.out.println(1/0);
			System.out.println(222222222);
		}catch(Exception e){
			System.out.println(33333);
			System.exit(0);
			return 1;
		}finally{
			System.out.println(44444);
		}
		return 0;
	}
	public static void main(String[] args) {
//		try{
//			System.out.println(11111111);
//			System.out.println(1/0);
//			System.out.println(222222222);
//		}catch(Exception e){
//			System.out.println("��������Ϊ0");
//			String message = e.getMessage();
//			e.printStackTrace();
////		}
		
//		try{
//			System.out.println(11111111);
//			System.out.println(1/0);
//			System.out.println(222222222);
//		}finally{
//			System.out.println("����ִ��");
//		}
		
		
		ExceptionDemo2 ed = new ExceptionDemo2();
		int i = ed.show();
		System.out.println(i);
	}

}
