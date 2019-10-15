package com.sia.dao;


import com.sia.bean.Emp;
import com.sia.util.BaseDao;

import java.util.List;

public class EmpDAOImpl implements IEmpDAO {
    private BaseDao<Emp> bd = new BaseDao<>();
    @Override
    public void add(Emp emp) {
        String sql = "INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?)";
        Object[] objects = {emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(Emp emp) {
        String sql = "UPDATE EMP SET ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? WHERE empno=?";
        Object[] objects = {emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer empno) {
        String sql = "DELETE FROM EMP WHERE empno=?";
        Object[] objects = {empno};
        bd.doSomething(sql,objects);
    }

    @Override
    public Emp getOne(Integer empno) {
        String sql = "SELECT * FROM EMP WHERE empno=?";
        Object[] objects={empno};
        List<Emp> emps = bd.getSomething(sql,objects,Emp.class);
        return emps.size()==0?null:emps.get(0);
    }

    @Override
    public List<Emp> getAll() {
        String sql = "SELECT * FROM EMP";
        Object[] objects={};
        return bd.getSomething(sql,objects,Emp.class);
    }
}