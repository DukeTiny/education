package com.cxz.controller;


import com.cxz.model.Student;
import com.cxz.service.IStuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StuController {

    private int count;

    @Resource
    private IStuService iStuServiceImpl;

    @GetMapping("/{sid}")
    public Student findById( @PathVariable Integer sid ) {
        System.out.println("I Am IN " + ++count);
        return iStuServiceImpl.findById(sid);
    }

}
