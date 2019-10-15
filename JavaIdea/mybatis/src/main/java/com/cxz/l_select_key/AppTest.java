package com.cxz.l_select_key;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {

    @Test
    public void testDept(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================
        DeptMapper mapper = s.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setdName("行政部");
        mapper.insert(dept);

        // ===========================================================================
        s.close();
    }

}
