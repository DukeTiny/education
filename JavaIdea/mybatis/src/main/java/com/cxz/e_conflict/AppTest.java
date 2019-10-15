package com.cxz.e_conflict;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class AppTest {

    @Test
    public void testSave(){
        SqlSession s = MybatisUtils.openSession();
        // ===========================================================================
        UserMapper mapper = s.getMapper(UserMapper.class);
        List<User> users= mapper.findAll();
        for ( User u : users ) {
            System.out.println(u);
        }
        // ===========================================================================
        s.close();
    }


}
