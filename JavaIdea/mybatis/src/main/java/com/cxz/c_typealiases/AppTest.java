package com.cxz.c_typealiases;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {

    @Test
    public void testSave(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================
        User user = new User();
        user.setName("嵇康");
        s.insert("com.cxz.c_typealiases.EmpMapper.save",user);
        // ===========================================================================
        s.close();
    }


}
