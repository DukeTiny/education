package com.cxz.app;

import com.cxz.dao.DeptMapper;
import com.cxz.entity.DeptExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class AppTest {


    public static void main(String[] args) {
        InputStream in = AppTest.class.getClassLoader().getResourceAsStream("");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        SqlSession s = sf.openSession(true);

        DeptMapper mapper = s.getMapper(DeptMapper.class);
        DeptExample de = new DeptExample();


    }


}
