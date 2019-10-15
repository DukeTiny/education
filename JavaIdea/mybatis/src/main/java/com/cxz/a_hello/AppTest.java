package com.cxz.a_hello;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AppTest {

    @Test
    public void testSave() throws Exception{
        InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        SqlSession s = sf.openSession();
        //======================================================================
        User user = new User();
        user.setId(1);
        user.setName("FeiFei");
        user.setBirthday(new Date());
        user.setMoney(100D);
        s.insert("com.cxz.a_hello.EmpMapper.save",user);
        //======================================================================
        s.commit();
        s.close();
    }
    @Test
    public void testUpdate() throws Exception{
        InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        SqlSession s = sf.openSession();
        //======================================================================
        User user = new User();
        user.setId(1);
        user.setName("Tiger");
        user.setBirthday(new Date());
        user.setMoney(2222D);
        s.update("com.cxz.a_hello.EmpMapper.update",user);
        //======================================================================
        s.commit();
        s.close();
    }
    @Test
    public void testDelete() throws Exception{
        InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        SqlSession s = sf.openSession();
        //======================================================================
        User user = new User();
        user.setId(1);
        s.delete("com.cxz.a_hello.EmpMapper.delete",user);
        //======================================================================
        s.commit();
        s.close();
    }

    @Test
    public void testFindAll() throws Exception{
        InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        SqlSession s = sf.openSession();
        //======================================================================
        List<User> users = s.selectList("com.cxz.a_hello.EmpMapper.findAll");
        for (User u : users) {
            System.out.println(u);
        }
        //======================================================================
        s.commit();
        s.close();
    }

    @Test
    public void testFindOne() throws Exception{
        InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        SqlSession s = sf.openSession();
        //======================================================================
        User user = new User();
        user.setId(3);
        user = s.selectOne("com.cxz.a_hello.EmpMapper.findOne", user);
        System.out.println(user);
        //======================================================================
        s.commit();
        s.close();
    }


}
