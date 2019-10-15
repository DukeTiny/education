package com.cxz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    public UserController() {
        System.out.println("AAAAAA");
    }

    @RequestMapping("hello")
    public String hello(){
        System.out.println("问候SpringBoot他大爷的。。。");
        return "index";
    }

}
