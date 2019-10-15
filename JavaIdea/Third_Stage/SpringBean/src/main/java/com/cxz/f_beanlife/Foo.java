package com.cxz.f_beanlife;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.io.Serializable;

public class Foo implements Serializable,BeanPostProcessor {

    private int count;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(++count);
        System.out.println("@@@@@@@@@@@@@@@: " + bean + "  ::::::::::    " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
        return bean;
    }

}
