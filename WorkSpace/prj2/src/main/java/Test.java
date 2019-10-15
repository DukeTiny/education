import redis.clients.jedis.Jedis;

import java.util.Iterator;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Jedis j = new Jedis("127.0.0.1");
        j.set("name","LiFei");
        j.set("age","1994");
        j.set("gender","Female");
        for (String s : j.keys("*")) {
            System.out.println( s + "==================" + j.get(s));
        }
    }

}
