package com.sia.dao;

import com.sia.bean.Course;

import java.util.List;

public class CourseDao {
    BaseDao<Course> bd = new BaseDao<>();
    public void add(Course course){
        String sql = "INSERT INTO Course VALUES(?,?,?)";
        Object[] objects = {course.getCno(),course.getCname(),course.getCnum()};
        bd.doSomething(sql,objects);
    }

    public void del(int cno){
        String sql = "DELETE FROM course WHERE cno=?";
        Object[] objects = {cno};
        bd.doSomething(sql,objects);
    }

    public void update(Course course){
        String sql = "UPDATE course SET cname=?,cnum=? WHERE cno=?";
        Object[] objects = {course.getCname(),course.getCnum(),course.getCno()};
        bd.doSomething(sql,objects);
    }

    public Course getSingle(int cno){
        String sql = "SELECT * FROM course WHERE cno="+cno;
        return bd.getSomething(sql,Course.class).get(0);
    }

    public List<Course> getAll(){
        String sql = "SELECT * FROM course";
        return bd.getSomething(sql,Course.class);
    }
}
