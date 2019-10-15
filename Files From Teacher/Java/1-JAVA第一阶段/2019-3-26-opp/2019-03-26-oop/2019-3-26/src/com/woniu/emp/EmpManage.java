package com.woniu.emp;

import java.util.Arrays;

public class EmpManage {
	//声明一个员工管理类，实现员工入职，员工离职，员工工资变动，
	//查询所有员工信息，某部门员工信息，某个员工信息等功能。
	Emp[] emps;
	int index;
	int size = 5;
	public EmpManage(){
		
	}
	public EmpManage(int n){
		emps = new Emp[n];
	}
	public void addEmp(Emp emp){
		if(size>=emps.length){
			int newSize = size + 1;
//			size = newSize;
			emps = Arrays.copyOf(emps, newSize);
		}
		emps[index++] = emp;
	}
	public int size(){
		return index;
	}
	public boolean removeEmp(String eno){
		for(int i=0;i<index;i++){
			Emp e = emps[i];
			if(eno.equals(e.getEno())){
				for(int j=i;j<index-1;j++){
					emps[j] = emps[j+1];
				}
				index--;
				return true;
			}
		}
		return false;
	}
	
	public boolean updateEmp(Emp emp){
		for(int i=0;i<index;i++){
			Emp e = emps[i];
			if(emp.getEno().equals(e.getEno())){
				emps[i] = emp;
				return true;
			}
		}
		return false;
	}
	
	public Emp[] getAllEmps(){
		return emps;
	}
	
	public Emp[] getDeptEmps(String dno){
		Emp[] temp = new Emp[emps.length];
		int tempIndex = 0;
		for(int i=0;i<index;i++){
			Emp e = emps[i];
			if(e.getDno().equals(dno)){
				temp[tempIndex++] = e;
			}
		}
		return temp;
	}
	
	public Emp getEmpByEno(String eno){
		for(int i=0;i<index;i++){
			Emp e = emps[i];
			if(eno.equals(e.getEno())){
				return e;
			}
		}
		return null;
	}
}



