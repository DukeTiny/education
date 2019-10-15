package com.cxz;

import com.cxz.netty.ChatServerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class  ChatApplication {

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(ChatApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(ChatApplication.class, args);
        ChatServerApplication chatServerApplication = context.getBean(ChatServerApplication.class);
        chatServerApplication.start();
    }

}
