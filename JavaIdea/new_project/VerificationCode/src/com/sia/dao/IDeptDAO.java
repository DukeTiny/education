package com.sia.dao;

import com.sia.bean.Dept;

import java.util.List;

public interface IDeptDAO {
    void add(Dept dept );
    void del(Integer deptno );
    void update(Dept dept );
    Dept getOne( Integer deptno );
    List<Dept> getAll();
}
