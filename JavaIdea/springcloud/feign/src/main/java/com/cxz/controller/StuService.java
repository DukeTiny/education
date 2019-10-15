package com.cxz.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("http://PROVIDER/")
public interface StuService {

    @GetMapping("/{sid}")
    Student findBySid( @PathVariable("sid") Integer sid );

}
