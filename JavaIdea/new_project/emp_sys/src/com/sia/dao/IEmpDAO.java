package com.sia.dao;

import com.sia.bean.Emp;

import java.util.List;

public interface IEmpDAO {
    void add(Emp emp);
    void update(Emp emp);
    void del(Integer empno);
    Emp getOne(Integer empno);
    List<Emp> getAll();
}
