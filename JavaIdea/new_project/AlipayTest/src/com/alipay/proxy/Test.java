package com.alipay.proxy;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject subject = (Subject) Proxy.newProxyInstance(Test.class.getClassLoader(),realSubject.getClass().getInterfaces(),new MyHandler(realSubject));
        System.out.println(subject.add(1,2));
    }

}
