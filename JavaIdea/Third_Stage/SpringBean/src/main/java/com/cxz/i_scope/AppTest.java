package com.cxz.i_scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    @Test
    void test(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/cxz/i_scope/applicationContext.xml");
        User user = (User)ctx.getBean("user");
        User user2 = (User)ctx.getBean("user");
        System.out.println(user);
        System.out.println(user2);
        System.out.println( user==user2 );
    }
}
