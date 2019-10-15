package com.cxz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = "com.cxz.mapper")
@SpringBootApplication
public class AppTest {

    public static void main(String[] args) {
        SpringApplication.run(AppTest.class,args);
    }

}
