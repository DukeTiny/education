package com.woniu.oop2;

import java.util.Arrays;

public class MyList2<T> {
	//����һ������Object �����Դ��κ����͵�����
	Object[] objs = new Object[10];
	//����һ���±�
	int index;
	//���Ԫ��
	public void add(T t){
		//�ж�����ռ�������
		if(this.objs.length<=index){
			//ʹ�������ݣ����ҽ�ԭ�����ֵ����
			//���������ĳ���
			int temp = this.objs.length*2;
//			Object[] Arrays.copyOf(Object[] objs,int newLen);
			this.objs = Arrays.copyOf(this.objs, temp);
		}
		//��Ԫ����ӵ�objs������ȥ���±����
		this.objs[this.index++] = t;
	}
	//�����±�ɾ��Ԫ��
	public void remove(int i){
		for(int j=i;j<this.index-1;j++){
			this.objs[j]= this.objs[j+1];
		}
		this.index--;
	}
	//����ֵɾ��Ԫ��
	public void remove(T t){
		for(int i=0;i<this.index;i++){
			if(t.equals(objs[i])){
				remove(i);
				break;
			}
		}
	}
	
	//�����������Чֵ�ĸ���
	public int size(){
		return this.index;
	}
	
	//�����±��ȡԪ��
	public T get(int i){
		return (T) this.objs[i];
	}
}
