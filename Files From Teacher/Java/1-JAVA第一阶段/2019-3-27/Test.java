package com.woniu.oop2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Iterator it2 = list.iterator();
//		while(it2.hasNext()){
//			System.out.println(it2.next());
//		}
		
		HashSet set = new HashSet();
		set.add(123);
		set.add("abc");
		set.add(123);
//		System.out.println(set.size());
//		//ֻ�ܰ��ն����Ƴ�
//		set.remove(123);
//		System.out.println(set.size());
		//������
		Iterator it = set.iterator();
		//�������Ƿ���ֵ hasNext();
		while(it.hasNext()){
			System.out.println(it.next());  //next()��ȡ��������һ��ֵ
		}
		
		//���һ���ַ����������������Щ�ַ�
		String str = "afj;safj;owaihaksfd";
		//����һ��HashSet���󣬴��벻�ظ���ֵ
		HashSet set2 = new HashSet();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			//��ÿ���ַ���ӵ�������
			set2.add(c);
		}
		//���ɵ�����
		Iterator it3 = set2.iterator();
		//�ж��Ƿ���ֵ
		while(it3.hasNext()){
			//��ȡ��һ��ֵ�������
			System.out.println(it3.next());
		}
	}

}
