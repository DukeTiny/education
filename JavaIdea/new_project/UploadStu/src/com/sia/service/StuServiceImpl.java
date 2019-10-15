package com.sia.service;

import com.sia.bean.Stu;
import com.sia.dao.DaoFactory;

import java.util.List;

public class StuServiceImpl implements IStuService{

    @Override
    public void add(Stu stu) {
        DaoFactory.getStuDao().add(stu);
    }

    @Override
    public void update(Stu stu) {
        DaoFactory.getStuDao().update(stu);
    }

    @Override
    public void del(Integer sid) {
        DaoFactory.getStuDao().del(sid);
    }

    @Override
    public Stu getOne(Integer sid) {
        return DaoFactory.getStuDao().getOne(sid);
    }

    @Override
    public List<Stu> getAll() {
        return DaoFactory.getStuDao().getAll();
    }

    public boolean isDone(){
        return DaoFactory.getStuDao().isDone();
    }
}
