package com.sia.service;

import com.sia.bean.PageNum;
import com.sia.bean.User;

public class BeanFactory {

    public static User getUserService(){
        return new User();
    }
    public static PageNum getPageNumService(){
        return new PageNum();
    }
}
