package com.cxz.job;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Configuration
public class MyJob {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled( fixedRate = 1000 )
    public void sendMessage(){
        System.out.println("This is From Server");
        simpMessagingTemplate.convertAndSend("/server/MessagesFromServer",System.currentTimeMillis() + "####");
    }

//    @Scheduled( fixedRate = 3000 )
//    public void sendMessageToUser(){
//        System.out.println("This is From Server To User");
//        simpMessagingTemplate.convertAndSendToUser("1","/MessagesFromServer",System.currentTimeMillis() + "@@@@@@@@");
//    }

}
