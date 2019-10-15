package com.sia.dao;

import com.sia.bean.Dept;
import com.sia.bean.Emp;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        EmpDAOImpl empDAO = new EmpDAOImpl();
        List<Emp> emps = empDAO.getAll();
        for (Emp e:emps ){
            System.out.println(e.getEmpno()+" : "+ e.getEname() + " : "+ e.getJob() + " : " +
            e.getHiredate() + " : " + e.getSal() + " : " + e.getComm() + " : " + e.getMgr() + " : " + e.getDeptno());
        }
        DeptDAOImpl dd = new DeptDAOImpl();
        List<Dept> depts = dd.getAll();
        for(Dept d:depts){
            System.out.println(d.getdeptno());
            System.out.println(d.getDname());
            System.out.println(d.getloc());
        }
    }

}
