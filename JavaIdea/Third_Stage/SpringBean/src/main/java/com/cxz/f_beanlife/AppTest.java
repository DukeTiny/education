package com.cxz.f_beanlife;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    @Test
    void test(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/cxz/f_beanlife/applicationContext.xml");
//        User user = (User)ctx.getBean("user");
//        System.out.println(user);
    }
}
