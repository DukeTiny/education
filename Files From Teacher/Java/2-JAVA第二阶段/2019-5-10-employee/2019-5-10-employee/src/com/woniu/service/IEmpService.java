package com.woniu.service;
import java.util.List;

import com.woniu.bean.Emp;

public interface IEmpService {
	void addEmp(Emp emp);
	void editEmp(Emp emp);
	void delEmp(Integer empno);
	Emp getEmp(Integer empno);
	List<Emp> getAllEmp();
	void turnDept(int parseInt, int parseInt2);
}
