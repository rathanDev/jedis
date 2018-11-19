package org.jana;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.Set;

public class App {

    private static final String host = "localhost";
    private static final int port = 6379;

    private static JedisPool pool;

    public App() {
        pool = new JedisPool(host, port);
        System.out.println("Constructed");
    }

    public void addSets() {
        String key = "members";
        String member1 = "Jana";
        String member2 = "Rathan";

        Jedis jedis = pool.getResource();

        try {
            //save
            jedis.sadd(key, member1, member2);

            //retrieve
            Set<String> smembers = jedis.smembers(key);
            for(String member: smembers) {
                System.out.println("member = " + member);
            }
        } catch (JedisException ex) {
            System.out.println("ex = " + ex);
        } finally {
            if(jedis != null) {
                pool.returnResource(jedis);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Redis");

//        App app = new App();
//        app.addSets();

        Jedis jedis = new Jedis(host, port);
        jedis.connect();
        System.out.println("jedis = " + jedis);
        jedis.auth("pola");

        String key = "members";
        String member1 = "Jana";
        String member2 = "Rathan";

        try {
            //save
            jedis.sadd(key, member1, member2);

            //retrieve
            Set<String> smembers = jedis.smembers(key);
            for(String member: smembers) {
                System.out.println("member = " + member);
            }
        } catch (JedisException ex) {
            System.out.println("ex = " + ex);
        } finally {
            jedis.close();
        }

    }

}
