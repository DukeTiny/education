package com.sia.dao;

import com.sia.bean.Dept;

import java.util.List;

public interface IDeptDAO {
    void add(Dept dept);
    void update(Dept dept);
    void del(Integer deptno);
    Dept getOne(Integer deptno);
    List<Dept> getAll();
}
