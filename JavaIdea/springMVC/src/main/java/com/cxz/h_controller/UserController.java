package com.cxz.h_controller;

import com.cxz.f_parameter.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("f1")
    public String f1(HttpServletRequest request){
        request.setAttribute("str","String");
        return "h";
    }

    @RequestMapping("f2")
    public String f2(Model model){
        User user = new User();
        user.setId(1);
        user.setName("Duke");
        user.setBirthday(new Date());
        user.setMoney(4000D);
        model.addAttribute("user",user);
        return "h";
    }
    @RequestMapping("f3")
    public User f3(HttpServletRequest request, HttpServletResponse response,HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return new User();
    }

}
