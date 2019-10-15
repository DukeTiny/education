package com.sia.dao;

import com.sia.bean.Dept;
import com.sia.util.BaseDao;

import java.util.List;

public class DeptDAOImpl implements IDeptDAO{
    private BaseDao<Dept> bd = new BaseDao<>();
    @Override
    public void add(Dept dept) {
        String sql = "INSERT INTO DEPT VALUES(?,?,?)";
        Object[] objects = {dept.getdeptno(),dept.getDname(),dept.getloc()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(Dept dept) {
        String sql = "UPDATE DEPT SET dname=?,loc=? WHERE deptno=?";
        Object[] objects = {dept.getDname(),dept.getloc(),dept.getdeptno()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer deptno) {
        String sql = "DELETE FROM DEPT WHERE deptno=?";
        Object[] objects = {deptno};
        bd.doSomething(sql,objects);
    }

    @Override
    public Dept getOne(Integer deptno) {
        String sql = "SELECT * FORM DEPT WHERE deptno=?";
        Object[] objects = {deptno};
        List<Dept> depts = bd.getSomething(sql,objects,Dept.class);
        return depts.size()==0?null:depts.get(0);
    }

    @Override
    public List<Dept> getAll() {
        String sql = "SELECT * FROM DEPT";
        Object[] objects = {};
        return bd.getSomething(sql,objects,Dept.class);
    }
}
