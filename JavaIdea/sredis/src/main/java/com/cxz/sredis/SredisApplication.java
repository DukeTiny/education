package com.cxz.sredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication
public class SredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SredisApplication.class, args);
    }

}
