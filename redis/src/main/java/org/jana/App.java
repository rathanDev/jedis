package org.jana;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

import java.util.Set;

public class App {

    private static final String host = "localhost";
    private static final int port = 6379;

    public static void main(String[] args) {
        System.out.println("Redis");

        Jedis jedis = new Jedis(host, port);
        jedis.connect();
        System.out.println("jedis = " + jedis);
//        jedis.auth("password");

        String memberKey = "members";
        String member1 = "Jana";
        String member2 = "Rathan";

        try {
            //save
            jedis.sadd(memberKey, member1, member2);

            //retrieve
            Set<String> smembers = jedis.smembers(memberKey);
            for(String member: smembers) {
                System.out.println("member = " + member);
            }

            Set<String> keys = jedis.keys("*");
            for(String key: keys) {
                System.out.println("key = " + key);
            }

        } catch (JedisException ex) {
            System.out.println("ex = " + ex);
        } finally {
            jedis.close();
        }

    }

}
