package com.sia.dao;

import com.sia.bean.Stu;

import java.util.List;

public interface IStuDao {
    void add(Stu stu);
    void update(Stu stu);
    void del(Integer sid);
    Stu getOne(Integer sid);
    List<Stu> getAll();
    boolean isDone();
}
