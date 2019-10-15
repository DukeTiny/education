package com.sia.service;

import com.sia.bean.Dept;
import com.sia.dao.DAOFactory;

import java.util.List;

public class DeptServiceImpl implements IDeptService{

    @Override
    public void add(Dept dept) {
        DAOFactory.getDeptDao().add(dept);
    }

    @Override
    public void update(Dept dept) {
        DAOFactory.getDeptDao().update(dept);
    }

    @Override
    public void del(Integer deptno) {
        DAOFactory.getDeptDao().del(deptno);
    }

    @Override
    public Dept getOne(Integer deptno) {
        return DAOFactory.getDeptDao().getOne(deptno);
    }

    @Override
    public List<Dept> getAll() {
        return DAOFactory.getDeptDao().getAll();
    }
}
