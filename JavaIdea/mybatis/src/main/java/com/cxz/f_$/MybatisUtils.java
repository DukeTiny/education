package com.cxz.f_$;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory sf;

    static {
        InputStream in = MybatisUtils.class.getResourceAsStream("mybatis-config.xml");
        sf = new SqlSessionFactoryBuilder().build(in);
    }

    public static SqlSession openSession(){
        return sf.openSession(true);
    }

}
