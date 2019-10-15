package com.woniuxy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 启动SpringBoot应用的类，上面必须加一个注解:
@SpringBootApplication(scanBasePackages = {"com.woniuxy"})
public class AppTest {
	
	public static void main(String[] args) {
		// 启动SpringBoot应用程序
		//		顺便也就把内嵌的tomcat也一起启动了,
		//		同时也把当前应用还部署到tomcat中
		//		同时，应用被部署到tomcat之后，应用名不是sb，而是ROOT
		//      还会扫包com.woniuxy，就会扫到Dog类，就能发现Dog类上有一个@ConfigurationProperties(prefix = "dog")
		//			进而，springboot就会拿着这个dog前缀，去application.properties中找该前置对应的配置，然后进行赋值！！
		SpringApplication.run(AppTest.class, args); 
	}
}