package com.cxz.controller;


import com.cxz.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class StuController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${user.serviceUrl}")
    private String serviceUrl;

    @GetMapping("/{sid}")
    public Student findById( @PathVariable Integer sid ) {
        return restTemplate.getForObject(serviceUrl+sid,Student.class);
    }

}
