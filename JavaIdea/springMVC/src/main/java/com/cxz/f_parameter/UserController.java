package com.cxz.f_parameter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("user")
public class UserController{

    @RequestMapping("f1")
    public ModelAndView f1(byte b,short s,int i,long l,float f,double d,boolean bb,char c){
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bb);
        System.out.println(c);
        return null;
    }

    @RequestMapping("f2")
    public ModelAndView f2(String username,String password){
        System.out.println( username + " : " + password );
        return null;
    }

    @RequestMapping("f3")
    public ModelAndView f3(User user){
        System.out.println(user);
        return null;
    }

    @RequestMapping("f4")
    public ModelAndView f4(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return null;
    }

    @RequestMapping("f5")
    public ModelAndView f5(@RequestParam List<String> hobby){
        System.out.println( hobby );
        return null;
    }

    @RequestMapping("f6")
    public ModelAndView f6(@RequestParam Set<String> hobby){
        System.out.println( hobby );
        return null;
    }

    @RequestMapping("f7")
    public ModelAndView f7(@RequestParam Map<String,String> hobby){
        System.out.println( hobby );
        return null;
    }

}
