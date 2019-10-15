package com.woniu.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionDemo {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("�ŷ�");
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("���");
		list.add("̫ʷ��");
		list.add("��Τ");
		list.add("����");
		list.add("��");
		
		
		Set set1 = new HashSet();
		//���������
		int x = 9;
		//ÿ��������湻�����佫
		while(set1.size()<3){
			//���list���±�
			int n1 = (int)(Math.random()*x);
			//��ȡlist�е��佫��
			String name = (String) list.get(n1);
			//����ȡ���佫������set�У�������óɹ��������佫����list���Ƴ��������-1
			if(set1.add(name)){
				list.remove(name);
				x--;
			}
		}
		Set set2 = new HashSet();
		while(set2.size()<3){
			int n1 = (int)(Math.random()*x);
			String name = (String) list.get(n1);
			if(set2.add(name)){
				list.remove(name);
				x--;
			}
		}
		Set set3 = new HashSet();
		while(set3.size()<3){
			int n1 = (int)(Math.random()*x);
			String name = (String) list.get(n1);
			if(set3.add(name)){
				list.remove(name);
				x--;
			}
		}
		
		//��������map
		Map map = new HashMap();
		//���������ƺ������佫�ֱ����key��value
		map.put("κ", set1);
		map.put("��", set2);
		map.put("��", set3);
		
		//���map������set
		Set s = map.keySet();
		Iterator it = s.iterator();
		while(it.hasNext()){
			//ȡ��������Ҳ����key
			String countryName = (String) it.next();
			System.out.println(countryName+":");
			//ͨ��key����佫set
			Set tempSet = (Set) map.get(countryName);
			Iterator it2 = tempSet.iterator();
			//ѭ��ȡ���佫��
			while(it2.hasNext()){
				String name = (String) it2.next();
				System.out.print(name+"��");
			}
			System.out.println();
		}
	}

}
