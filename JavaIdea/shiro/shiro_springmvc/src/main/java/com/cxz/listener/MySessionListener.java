package com.cxz.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class MySessionListener implements SessionListener {
    @Override
    public void onStart(Session session) {
        System.out.println("开始了。。。。。");
    }

    @Override
    public void onStop(Session session) {
        System.out.println("结束了。。。。。");
    }

    @Override
    public void onExpiration(Session session) {
        System.out.println("坏掉了。。。。。");
    }
}
