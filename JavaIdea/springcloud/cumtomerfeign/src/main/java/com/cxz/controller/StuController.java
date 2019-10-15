package com.cxz.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {

    @GetMapping("/{sid}")
    public Student findBySid( @PathVariable Integer sid ) {
        return null;
    }


}
