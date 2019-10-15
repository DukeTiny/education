package com.sia.dao;

import com.sia.bean.Dept;
import com.sia.util.BaseDao;

import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements IDeptDAO {

    private static BaseDao<Dept> bd = new BaseDao<>();

    public static void main(String[] args) {
        Object[] objects = {};
        bd.doSomething("CREATE TABLE ff(stu VARCHAR(20))",objects);
    }

    @Override
    public void add(Dept dept) {
        String sql = "INSERT INTO dept VALUES(?,?,?)";
        Object[] objects =  {dept.getDeptname(),dept.getLoc(),dept.getNum()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer deptno) {

    }

    @Override
    public void update(Dept dept) {

    }

    @Override
    public Dept getOne(Integer deptno) {
        return null;
    }

    @Override
    public List<Dept> getAll()
    {
        String sql = "SELECT * FROM dept";
        Object[] objects = {};
        List<Dept> deptList = bd.getSomething(sql,objects,Dept.class);
        return deptList;
    }
}
