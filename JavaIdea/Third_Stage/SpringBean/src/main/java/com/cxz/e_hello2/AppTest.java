package com.cxz.e_hello2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class AppTest {

    @Test
    void test(){
        Resource resource =
                new ClassPathResource("com/cxz/e_hello2/applicationContext.xml");
        BeanFactory bf = new XmlBeanFactory(resource);
        Toy toy = (Toy) bf.getBean("toy");
        System.out.println(toy);
        User user = (User) bf.getBean("user");
        System.out.println("user = " + user);
    }
}
