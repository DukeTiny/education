package com.woniu.emp;

public class DeptManage {
//	����һ�����Ź����࣬�г�����˾���ƣ��о�̬�������³���
//	ʵ���������ţ����ų������鿴ĳ������Ϣ��
	final String COMPANY_NAME = "��ţ";
	static String ceo = "�ϵ�";
	Dept[] depts = new Dept[10];
	int index;
	public void addDept(Dept dept){
		depts[index++] = dept;
	}
	public boolean removeDept(String dno){
		for(int i=0;i<index;i++){
			Dept d= depts[i];
			if(d.getDno().equals(dno)){
				for(int j=i;j<index-1;j++){
					depts[j] = depts[j+1];
				}
				index--;
				return true;
			}
		}
		return false;
	}
	public Dept[] getAllDepts(){
		return depts;
	}
	public Dept getDeptByDno(String dno){
		for(int i=0;i<index;i++){
			Dept d= depts[i];
			if(d.getDno().equals(dno)){
				return d;
			}
		}
		return null;
	}
}
