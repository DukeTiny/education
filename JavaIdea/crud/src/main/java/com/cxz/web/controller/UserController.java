package com.cxz.web.controller;

import com.cxz.domain.Userinfo;
import com.cxz.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private IUserService iUserService;

    @RequestMapping("/reg")
    @ResponseBody
    public String reg(Userinfo userinfo){
        System.out.println(iUserService);
        System.out.println(userinfo);
        iUserService.save(userinfo);
        return "redirect:/list.html";
    }

//    @ResponseBody
    @RequestMapping("test")
    public String test(){
        System.out.println("UserController.test");
        return "a";
    }

}
