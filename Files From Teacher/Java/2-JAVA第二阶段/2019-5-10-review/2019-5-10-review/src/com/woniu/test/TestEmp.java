package com.woniu.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.woniu.bean.Emp;
import com.woniu.service.ServiceFactory;

public class TestEmp {

	@Test
	public void testAdd() {
		ServiceFactory.getEmpService().addEmp(new Emp(8002,"jack","salesman",7839,new Date(),6000d,200d,20));
	}

	@Test
	public void testFindAll() {
		List<Emp> emps = ServiceFactory.getEmpService().getAllEmp();
		for(Emp e:emps){
			System.out.println(e.getEmpno()+":"+e.getEname()+":"+e.getJob()+":"+e.getMgr()+":"+e.getHiredate()+":"+e.getSal()+":"+e.getComm()+":"+e.getDeptno());
		}
	}
}
