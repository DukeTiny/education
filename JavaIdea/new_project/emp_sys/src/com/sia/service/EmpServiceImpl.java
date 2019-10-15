package com.sia.service;

import com.sia.bean.Emp;
import com.sia.dao.DAOFactory;

import java.util.List;

public class EmpServiceImpl implements IEmpService {
    @Override
    public void add(Emp emp) {
        DAOFactory.getEmpDao().add(emp);
    }

    @Override
    public void update(Emp emp) {
        DAOFactory.getEmpDao().update(emp);
    }

    @Override
    public void del(Integer empno) {
        DAOFactory.getEmpDao().del(empno);
    }

    @Override
    public Emp getOne(Integer empno) {
        return DAOFactory.getEmpDao().getOne(empno);
    }

    @Override
    public List<Emp> getAll() {
        return DAOFactory.getEmpDao().getAll();
    }
}
