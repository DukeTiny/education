package com.cxz;

import redis.clients.jedis.Jedis;

import java.lang.reflect.Modifier;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Jedis j = new Jedis("127.0.0.1");

        j.hset("Test","name","Duke");
        System.out.println(j.hget("Test","name"));


//        j.rpush("students",1);

//        j.set()
//        int[] i = {6};
//        test(i);
//        System.out.println(i[0]);
    }

    public static void test( int[] i ) {
        i[0] = 5;
        System.out.println(i[0]);
    }


}
