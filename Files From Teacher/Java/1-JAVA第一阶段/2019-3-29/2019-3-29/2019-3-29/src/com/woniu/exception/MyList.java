package com.woniu.exception;

public class MyList {
	Object[] objs = new Object[2];
	int index = 0;
	public void add(Object obj){
		if(index>=objs.length){
			throw new ArrayIndexOutOfBoundsException("�����Ѿ�������");
		}
		objs[index++] = obj;
	}
	
	public static void main(String[] args) {
		MyList m = new MyList();
		m.add("abc");
		m.add("bbb");
		m.add("ccc");
	}
}
