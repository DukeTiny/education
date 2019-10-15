package com.cxz.h_one2many;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {

    @Test
    public void testDept(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================
        DeptMapper mapper = s.getMapper(DeptMapper.class);

        Dept d = mapper.findOne(1);
        System.out.println(d);
        System.out.println(d.getEmps());

        // ===========================================================================
        s.close();
    }


    @Test
    public void testWife(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================

        EmpMapper mapper = s.getMapper(EmpMapper.class);
        Emp e = mapper.findOne(4);

        System.out.println(e);
        System.out.println(e.getDept());


        // ===========================================================================
        s.close();
    }


}
