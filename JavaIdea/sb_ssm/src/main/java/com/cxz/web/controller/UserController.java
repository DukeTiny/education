package com.cxz.web.controller;


import com.cxz.entity.User;
import com.cxz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("users")
public class UserController {


    @Autowired
    private IUserService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String save(){
        System.out.println("UserController.save"+service.getClass());
        User user = new User();
        user.setName("FeiFei");
        service.save(user);
        return "A";
    }

}
