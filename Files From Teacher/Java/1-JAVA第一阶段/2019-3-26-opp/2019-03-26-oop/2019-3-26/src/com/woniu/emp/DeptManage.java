package com.woniu.emp;

public class DeptManage {
//	声明一个部门管理类，有常量公司名称，有静态变量董事长，
//	实现新增部门，部门撤销，查看某部门信息。
	final String COMPANY_NAME = "蜗牛";
	static String ceo = "老邓";
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
