package com.cxz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("com.cxz.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderApplication {

    public static void main( String[] args ) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
