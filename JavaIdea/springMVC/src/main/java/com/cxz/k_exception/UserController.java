package com.cxz.k_exception;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("f1")
    public String f1(){
        File file = new File("aaaaa.txt");
        if(!file.exists()) throw new RuntimeException();
        return "k";
    }

}
