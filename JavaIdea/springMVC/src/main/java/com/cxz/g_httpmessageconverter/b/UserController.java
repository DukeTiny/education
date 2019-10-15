package com.cxz.g_httpmessageconverter.b;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("f1")
    public ModelAndView f1(@RequestBody User user){
        System.out.println(user);
        return null;
    }

    @RequestMapping("f2")
    @ResponseBody
    public ModelAndView f2(){
        System.out.println("A");
        return new ModelAndView("g");
    }

    @RequestMapping("f3")
    @ResponseBody
    public String f3(){
        System.out.println("BBBBB");
        return "g";
    }

    @RequestMapping("f4")
    @ResponseBody
    public User f4(){
        System.out.println("CCCCC");
        User user = new User();
        user.setId(1);
        user.setName("Duke");
        user.setBirthday(new Date());
        user.setMoney(33.3D);
        return user;
    }



}
