package com.stranger.camping.campingproductclient.controller;


import com.stranger.camping.campingproductclient.model.Util;
import com.stranger.camping.campingproductclient.mq.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class MsgController {
    @Resource
    private MsgProducer msgProducer;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/send")
    public String send(String name,Integer id){//传递商品id和用户名
        //调用msgProducer的sendMsg方法将参数传递到路由器再传递到队列中
        Util util = Util.createUtil(name, id);
        msgProducer.sendMsg(util);
        if (util.getName()!=null &&redisTemplate.boundValueOps(util.getName()).get()!= null) {
            return "success";
        }
        return "fail";
        }



}