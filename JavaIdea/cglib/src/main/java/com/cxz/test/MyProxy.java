package com.cxz.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyProxy implements MethodInterceptor {

    private Calc target;

//    public MyProxy( Calc c ) {
//        this.c = c;
//    }

    public Object getInstance(Object target) {
        this.target = (Calc) target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }



    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println( o.getClass().getSimpleName() );
        System.out.println(methodProxy.invokeSuper(o, objects));
        return method.invoke(target,objects);
    }


    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        Calc calc = (Calc)myProxy.getInstance(new Calc());
        System.out.println(calc.add(1, 2));
    }


}
