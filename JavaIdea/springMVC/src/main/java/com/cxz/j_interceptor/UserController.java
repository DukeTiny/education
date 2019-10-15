package com.cxz.j_interceptor;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("f1")
    public String f1(){
        System.out.println("UserController.f1");
        return "j";
    }

}
