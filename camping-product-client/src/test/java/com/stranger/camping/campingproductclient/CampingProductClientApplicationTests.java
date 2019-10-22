package com.stranger.camping.campingproductclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampingProductClientApplicationTests {

    @Test
    public void contextLoads() {
        Jedis jedis=new Jedis();
        jedis.set("1","0");
    }

}
