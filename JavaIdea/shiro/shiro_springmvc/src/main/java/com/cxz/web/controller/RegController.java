package com.cxz.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RegController {

    @RequiresRoles("superAdmin")
    @RequestMapping("/reg")
    public String reg(){
        System.out.println("RegController.reg");
        return "/html/reg.html";
    }

    @RequiresRoles("admin")
    @RequestMapping("/login")
    public String login(){
        System.out.println("RegController.reg");
        return "/index.html";
    }

}
