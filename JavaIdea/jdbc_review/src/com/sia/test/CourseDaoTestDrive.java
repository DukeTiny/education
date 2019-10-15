package com.sia.test;

import com.sia.bean.Course;
import com.sia.dao.CourseDao;

import java.util.List;

public class CourseDaoTestDrive {
    public static void main(String[] args) {
        CourseDao cd = new CourseDao();
//        Course course = new Course("4","Biology","10");
//        cd.add(course);
//        cd.del(3);
//        cd.update( course );
//        List<Course> list = cd.getAll();
        Course course = cd.getSingle(1);
        System.out.println( course.getCno() + "  " + course.getCname() + "  " + course.getCnum());
//        for ( int i=0; i<list.size(); i++ ){
//            System.out.print(list.get(i).getCno() + "  ");
//            System.out.print(list.get(i).getCname() + "  ");
//            System.out.println(list.get(i).getCnum());
//        }
    }
}
