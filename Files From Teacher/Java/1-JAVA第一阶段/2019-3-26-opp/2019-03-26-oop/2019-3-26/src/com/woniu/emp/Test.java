package com.woniu.emp;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		//ʹ������������������ţ���Ӧ���ŷֱ��������Ա����
		
		Dept dept1 = new Dept("1","���۲�");
		Dept dept2 = new Dept();
		dept2.setDno("2");
		dept2.setDname("���ڲ�");
		Dept dept3 = new Dept("3","�г���");
		
		DeptManage dm = new DeptManage();
		dm.addDept(dept1);
		dm.addDept(dept2);
		dm.addDept(dept3);
		
		Emp emp1 = new Emp();
		emp1.setEno("1");
		emp1.setEname("Jack");
		emp1.setEsalary(5000);
		emp1.setEsex("Ů");
		emp1.setEbirth(new Date(95,3,10));
		emp1.setDno("1");
		Emp emp2 = new Emp();
		emp2.setEno("2");
		emp2.setEname("Jack2");
		emp2.setEsalary(15000);
		emp2.setEsex("��");
		emp2.setEbirth(new Date(95,3,10));
		emp2.setDno("1");
		Emp emp3 = new Emp();
		emp3.setEno("3");
		emp3.setEname("andy");
		emp3.setEsalary(6000);
		emp3.setEsex("Ů");
		emp3.setEbirth(new Date(95,3,10));
		emp3.setDno("2");
		Emp emp4 = new Emp();
		emp4.setEno("4");
		emp4.setEname("����");
		emp4.setEsalary(3000);
		emp4.setEsex("Ů");
		emp4.setEbirth(new Date(95,3,10));
		emp4.setDno("2");
		Emp emp5 = new Emp();
		emp5.setEno("5");
		emp5.setEname("����");
		emp5.setEsalary(4500);
		emp5.setEsex("��");
		emp5.setEbirth(new Date(95,3,10));
		emp5.setDno("3");
		Emp emp6 = new Emp();
		emp6.setEno("6");
		emp6.setEname("����");
		emp6.setEsalary(1500);
		emp6.setEsex("��");
		emp6.setEbirth(new Date(95,3,10));
		emp6.setDno("3");
		
		EmpManage em = new EmpManage(5);
		em.addEmp(emp1);
		em.addEmp(emp2);
		em.addEmp(emp3);
		em.addEmp(emp4);
		em.addEmp(emp5);
		em.addEmp(emp6);
		
		Emp[] emps = em.getAllEmps();
		for(int i=0;i<emps.length;i++){
			if(emps[i]!=null){
				System.out.println(emps[i].getEname());
			}
		}
		
//		//��ѯ2�Ų��ŵ�����Ա�������ܺͣ�
//		Emp[] deptEmps = em.getDeptEmps("2");
//		float sumSalary = 0;
//		for(int i=0;i<deptEmps.length;i++){
//			Emp emp = deptEmps[i];
//			if(emp!=null){
//				sumSalary+=emp.getEsalary();
//			}
//		}
//		System.out.println(sumSalary);
//		//ɾ��1�Ų��ţ�
//		boolean flag = dm.removeDept("1");
//		System.out.println(flag?"ɾ���ɹ�":"ɾ��ʧ��");
//		//ɾ��1��Ա����
//		boolean flag2 = em.removeEmp("1");
//		System.out.println(flag2?"ɾ���ɹ�":"ɾ��ʧ��");
	}

}
