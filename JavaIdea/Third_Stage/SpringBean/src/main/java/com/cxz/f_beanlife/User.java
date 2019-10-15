package com.cxz.f_beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;

public class User implements Serializable,BeanNameAware,BeanFactoryAware,ApplicationContextAware
    ,InitializingBean
{

    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public void methodInit() {
        System.out.println("User.methodInit");
    }
    public void methodInit2() {
        System.out.println("User.methodInit2");
    }

    public void setId(Integer id) {
        System.out.println("id = [" + id + "]");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("name = [" + name + "]");
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("User.setBeanName" + " ::: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("User.setBeanFactory" + " ::: " + beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        User user = (User) ctx.getBean("user");
        System.out.println("user = " + user);
        System.out.println("User.setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("##################");
    }
}
