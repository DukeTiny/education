package com.cxz.j_di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    @Test
    void test(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/cxz/j_di/applicationContext.xml");
        User user = (User)ctx.getBean("user");
        System.out.println(user);
        System.out.println(user.getCar());
    }
}
