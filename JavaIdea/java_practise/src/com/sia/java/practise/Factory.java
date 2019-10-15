package com.sia.java.practise;

import com.sia.java.practise.test_practise.Practise12;

public class Factory  {


    public static Practise12 get() throws IllegalAccessException, InstantiationException {
        return Practise12.class.newInstance();
    }

}