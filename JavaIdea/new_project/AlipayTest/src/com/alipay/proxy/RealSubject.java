package com.alipay.proxy;

public class RealSubject implements Subject {

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
