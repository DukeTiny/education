package com.cxz.i_many2many;

import com.cxz.h_one2many.Dept;
import com.cxz.h_one2many.DeptMapper;
import com.cxz.h_one2many.Emp;
import com.cxz.h_one2many.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class AppTest {

    @Test
    public void testDept(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================
        StudentMapper mapper = s.getMapper(StudentMapper.class);

        List<Student> students = mapper.findAll();
        for ( Student stu : students ) {
            System.out.println(stu);
            System.out.println(stu.getTeachers());
        }

        // ===========================================================================
        s.close();
    }


    @Test
    public void testWife(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================
        TeacherMapper mapper = s.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.findAll();

        for ( Teacher t : teachers ) {
            System.out.println(t);
            System.out.println(t.getStudents());
        }


        // ===========================================================================
        s.close();
    }


}
