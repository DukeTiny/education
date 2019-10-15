package com.cxz.j_di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class AppTest {

    void test(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/cxz/j_di2/applicationContext.xml");
        Foo foo = (Foo) ctx.getBean("foo");
        List list = foo.getList();
        for (Object o : list) {
            System.out.print(o + "  ");
        }

        Set set = foo.getSet();
        System.out.println();
        for ( Object o : set ) {
            System.out.print(o + "  ");
        }

        System.out.println();

        Map map = foo.getMap();
        Set<Map.Entry<Object,Object>> entrySet = map.entrySet();
        for (Map.Entry<Object,Object> o : entrySet) {
            System.out.println(o.getKey() + " ::: " + o.getValue());
        }

        Properties properties = foo.getProp();
        Set<Map.Entry<Object,Object>> entrySet1 = properties.entrySet();
        for (Map.Entry<Object, Object> e : entrySet1) {
            System.out.println(e.getKey() + " ::: " + e.getValue());
        }

    }
}
