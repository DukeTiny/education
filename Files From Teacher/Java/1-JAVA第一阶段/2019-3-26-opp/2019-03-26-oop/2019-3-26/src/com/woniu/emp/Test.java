package com.woniu.emp;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		//使用运行类添加三个部门，对应部门分别添加两个员工，
		
		Dept dept1 = new Dept("1","销售部");
		Dept dept2 = new Dept();
		dept2.setDno("2");
		dept2.setDname("后勤部");
		Dept dept3 = new Dept("3","市场部");
		
		DeptManage dm = new DeptManage();
		dm.addDept(dept1);
		dm.addDept(dept2);
		dm.addDept(dept3);
		
		Emp emp1 = new Emp();
		emp1.setEno("1");
		emp1.setEname("Jack");
		emp1.setEsalary(5000);
		emp1.setEsex("女");
		emp1.setEbirth(new Date(95,3,10));
		emp1.setDno("1");
		Emp emp2 = new Emp();
		emp2.setEno("2");
		emp2.setEname("Jack2");
		emp2.setEsalary(15000);
		emp2.setEsex("男");
		emp2.setEbirth(new Date(95,3,10));
		emp2.setDno("1");
		Emp emp3 = new Emp();
		emp3.setEno("3");
		emp3.setEname("andy");
		emp3.setEsalary(6000);
		emp3.setEsex("女");
		emp3.setEbirth(new Date(95,3,10));
		emp3.setDno("2");
		Emp emp4 = new Emp();
		emp4.setEno("4");
		emp4.setEname("张三");
		emp4.setEsalary(3000);
		emp4.setEsex("女");
		emp4.setEbirth(new Date(95,3,10));
		emp4.setDno("2");
		Emp emp5 = new Emp();
		emp5.setEno("5");
		emp5.setEname("李四");
		emp5.setEsalary(4500);
		emp5.setEsex("男");
		emp5.setEbirth(new Date(95,3,10));
		emp5.setDno("3");
		Emp emp6 = new Emp();
		emp6.setEno("6");
		emp6.setEname("王五");
		emp6.setEsalary(1500);
		emp6.setEsex("男");
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
		
//		//查询2号部门的所有员工工资总和，
//		Emp[] deptEmps = em.getDeptEmps("2");
//		float sumSalary = 0;
//		for(int i=0;i<deptEmps.length;i++){
//			Emp emp = deptEmps[i];
//			if(emp!=null){
//				sumSalary+=emp.getEsalary();
//			}
//		}
//		System.out.println(sumSalary);
//		//删除1号部门，
//		boolean flag = dm.removeDept("1");
//		System.out.println(flag?"删除成功":"删除失败");
//		//删除1号员工。
//		boolean flag2 = em.removeEmp("1");
//		System.out.println(flag2?"删除成功":"删除失败");
	}

}
