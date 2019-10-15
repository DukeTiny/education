package com.cxz.m_restful;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("users")
public class UserController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String save(){
        System.out.println("save...");
        return "m";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(){
        System.out.println("findAll...");
        return "m";
    }

    @ResponseBody
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public User f3(@PathVariable int id){
        System.out.println("findOne...");
        return new User(1,"Duke",new Date(),200D);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public User f4(String abc){
        System.out.println(abc);
        System.out.println("Delete...");
        return new User(1,"Duke",new Date(),200D);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public User f5(String abc){
        System.out.println(abc);
        System.out.println("Update...");
        return new User(1,"Duke",new Date(),200D);
    }

}
