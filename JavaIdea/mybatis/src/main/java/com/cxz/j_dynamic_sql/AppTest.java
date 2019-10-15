package com.cxz.j_dynamic_sql;

import com.cxz.b_parameter.Foo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class AppTest {


    @Test
    public void test()throws Exception{
        SqlSession s = MybatisUtils.openSession();
        //====================================================================
        UserMapper mapper = s.getMapper(UserMapper.class);
        UserExample ue = new UserExample();
        ue.setId(3);
        List<User> users = mapper.find4(ue);
        for ( User user : users ) {
            System.out.println(user);
        }

        //====================================================================
        s.close();
    }

}
