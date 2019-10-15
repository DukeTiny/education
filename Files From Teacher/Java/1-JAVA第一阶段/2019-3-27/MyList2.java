package com.woniu.oop2;

import java.util.Arrays;

public class MyList2<T> {
	//定义一个数组Object ，可以存任何类型的数据
	Object[] objs = new Object[10];
	//定义一个下标
	int index;
	//添加元素
	public void add(T t){
		//判断数组空间已用完
		if(this.objs.length<=index){
			//使数组增容，并且将原数组的值存入
			//获得新数组的长度
			int temp = this.objs.length*2;
//			Object[] Arrays.copyOf(Object[] objs,int newLen);
			this.objs = Arrays.copyOf(this.objs, temp);
		}
		//将元素添加到objs数组中去，下标后移
		this.objs[this.index++] = t;
	}
	//根据下标删除元素
	public void remove(int i){
		for(int j=i;j<this.index-1;j++){
			this.objs[j]= this.objs[j+1];
		}
		this.index--;
	}
	//根据值删除元素
	public void remove(T t){
		for(int i=0;i<this.index;i++){
			if(t.equals(objs[i])){
				remove(i);
				break;
			}
		}
	}
	
	//获得数组中有效值的个数
	public int size(){
		return this.index;
	}
	
	//根据下标获取元素
	public T get(int i){
		return (T) this.objs[i];
	}
}
