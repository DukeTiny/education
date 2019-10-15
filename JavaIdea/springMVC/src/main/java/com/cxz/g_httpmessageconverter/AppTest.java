package com.cxz.g_httpmessageconverter;

import com.cxz.f_parameter.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppTest {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setId(1);
        user.setName("Duke");
        user.setBirthday(new Date());
        user.setMoney(600D);

        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(user);
        System.out.println(jsonStr);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user);
        list.add(user);

        String jsonStr2 = om.writeValueAsString(list);
        System.out.println(jsonStr2);

        System.out.println("========================================");

        long birthday = new Date("1990/9/19").getTime();
        String json = "{\"id\":\"1\",\"name\":\"Duke\",\"birthday\":"+birthday+",\"money\":\"333.3\"}";
        User user1 = om.readValue(json,User.class);
        System.out.println(user1);

    }


}
