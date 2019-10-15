package com.woniu.oop2;

import java.util.Arrays;

public class MyList<T> {
	private Object[] objs = {};
	private int index = 0;
	private int len = 5;
	public MyList(){
		objs = new Object[len];
	}
	public void add(T t){
		if(objs.length<=index){
			grow();
		}
		objs[index++] = t;
	}
	private void grow() {
		int newLen = len+len;
		len = newLen;
//		Object[] temp = new Object[len];
//		for(int i=0;i<objs.length;i++){
//			temp[i] = objs[i];
//		}
//		objs=temp;
		objs = Arrays.copyOf(objs, len);
	}
	public int size(){
		return index;
	}
	public T get(int index){
		return (T)objs[index];
	}
	public void remove(int index){
		for(int i=index;i<this.index-1;i++){
			objs[i] = objs[i+1];
		}
		this.index--;
	}
	public void remove(T t){
		for(int i=0;i<this.index;i++){
			T temp = (T) objs[i];
			if(temp.equals(t)){
				remove(i);
			}
		}
	}
}
