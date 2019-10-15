package com.cxz.controller;

import com.cxz.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
@RequestMapping("/socket")
public class IndexController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/index")
    public String index() {
        simpMessagingTemplate.convertAndSend("/server/MessagesFromServer","ssssss");
        return "index";
    }

    @MessageMapping("/message")
    public void message(Message message){
        System.out.println(message);
        simpMessagingTemplate.convertAndSendToUser(message.getToUser(),"/message/fromUser",message);
    }
}
