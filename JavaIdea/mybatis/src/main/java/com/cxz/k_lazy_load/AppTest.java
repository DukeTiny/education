package com.cxz.k_lazy_load;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {

    @Test
    public void testDept(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================
        DeptMapper mapper = s.getMapper(DeptMapper.class);

        Dept dept = mapper.find(1);
        System.out.println(dept.getdName());
        System.out.println(dept.getEmps());

        // ===========================================================================
        s.close();
    }

}
