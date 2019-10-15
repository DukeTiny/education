package com.cxz.e_hello;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    @Test
    void test(){
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/cxz/e_hello/applicationContext.xml");
        Toy toy = (Toy) ctx.getBean("toy");
        System.out.println(toy);
        User user = (User) ctx.getBean("user");
        System.out.println("user = " + user);
    }
}
