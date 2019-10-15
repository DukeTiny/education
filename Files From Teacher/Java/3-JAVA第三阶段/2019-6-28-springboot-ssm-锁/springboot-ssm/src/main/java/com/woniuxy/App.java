package com.woniuxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement			// 使用注解，启用声明式事务
@MapperScan("com.woniuxy.dao")			// 指定去哪里找mybatis的子配置文件。
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
