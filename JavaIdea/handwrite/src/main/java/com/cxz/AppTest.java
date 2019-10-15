package com.cxz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cxz.mapper")
public class AppTest {
    public static void main(String[] args) {
        SpringApplication.run(AppTest.class,args);
    }

}
