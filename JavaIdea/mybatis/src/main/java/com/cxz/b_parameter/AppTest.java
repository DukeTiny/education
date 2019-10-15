package com.cxz.b_parameter;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppTest {


    @Test
    public void test()throws Exception{
        SqlSession s = MybatisUtils.openSession();
        //====================================================================
        User user = new User();
        user.setId(1);
        user.setName("LiFei");
        user.setBirthday(new Date("1994/10/27"));
        user.setMoney(200D);
        s.insert("com.cxz.b_parameter.EmpMapper.save",user);
        //====================================================================
        s.close();
    }

    @Test
    public void testFoo()throws Exception{
        SqlSession s = MybatisUtils.openSession();
        //====================================================================
        Foo foo = new Foo();
        foo.setName("Joe");
        foo.setBirthday(new Date("1994/10/27"));
        foo.setMoney(500D);
        s.insert("com.cxz.b_parameter.EmpMapper.save",foo);
        //====================================================================
        s.close();
    }

    @Test
    public void testMap()throws Exception{
        SqlSession s = MybatisUtils.openSession();
        //====================================================================
        Map<String,Object> map = new HashMap();
        map.put("name","Harden");
        map.put("birthday",new Date());
        map.put("money",999D);
        s.insert("com.cxz.b_parameter.EmpMapper.save",map);
        //====================================================================
        s.close();
    }

}
