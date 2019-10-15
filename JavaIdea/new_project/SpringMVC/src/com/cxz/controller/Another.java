package com.cxz.controller;

import com.cxz.annotation.Controller;
import com.cxz.annotation.RequestMapping;


@Controller
@RequestMapping("/another")
public class Another {

    @RequestMapping("/test.do")
    public void test(String name,int num) {
        System.out.println(name + " : " + num );
    }

    @RequestMapping("/anotherTest")
    public void anotherTest(String name,int num){
        System.out.println(name + " : " + num );
    }

    public static void main(String[] args) {

    }
}
