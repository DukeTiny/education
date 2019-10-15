package com.cxz.k_dependson;

import com.cxz.j_di.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    @Test
    void test(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/cxz/k_dependson/applicationContext.xml");
    }
}
