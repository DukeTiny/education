package com.cxz.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StuController {

    @Resource
    private StuService stuService;

    @GetMapping("/stu/{sid}")
    public Student findBySid( @PathVariable Integer sid ){
        System.out.println(sid);
        return stuService.findBySid(sid);
    }

}
