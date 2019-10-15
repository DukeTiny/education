package com.sia.dao;

import com.sia.bean.Stu;
import com.sia.util.BaseDao;

import java.util.List;

public class StudaoImpl implements IStuDao {

    BaseDao<Stu> bd = new BaseDao<>();


    @Override
    public void add(Stu stu) {
        String sql = "INSERT INTO stu VALUES(null,?,?)";
        Object[] objects = {stu.getsName(),stu.getsPhoto()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void update(Stu stu) {
        String sql = "UPDATE stu SET sname=?,sphoto=? WHERE sid=?";
        Object[] objects = {stu.getsName(),stu.getsPhoto(),stu.getSid()};
        bd.doSomething(sql,objects);
    }

    @Override
    public void del(Integer sid) {
        String sql = "DELETE FROM stu WHERE sid=?";
        Object[] objects = {sid};
        bd.doSomething(sql,objects);
    }

    @Override
    public Stu getOne(Integer sid) {
        String sql = "SELECT * FROM stu WHERE sid=?";
        Object[] objects = {sid};
        List<Stu> stus = bd.getSomething(sql,objects,Stu.class);
        return stus.size()==0?null:stus.get(0);
    }

    @Override
    public List<Stu> getAll() {
        String sql = "SELECT * FROM stu";
        Object[] objects = {};
        return bd.getSomething(sql,objects,Stu.class);
    }

    @Override
    public boolean isDone(){
        return bd.isDone();
    }

}
