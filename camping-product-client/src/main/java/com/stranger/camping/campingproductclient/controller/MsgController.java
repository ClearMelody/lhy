package com.stranger.camping.campingproductclient.controller;


import com.stranger.camping.campingproductclient.model.Util;
import com.stranger.camping.campingproductclient.mq.MsgProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
public class MsgController {
    @Resource
    private MsgProducer msgProducer;
    @RequestMapping("/send")
    public String send(String name,Integer id){//传递商品id和用户名
        //调用msgProducer的sendMsg方法将参数传递到路由器再传递到队列中
        Util util = Util.createUtil(name, id);
        msgProducer.sendMsg(util);
        //        return "redirect:http://localhost:9301/api-a/product/findbyid?id="+id;
        return  "redirect:http://localhost:9301/select?orderDesc="+name+"&productId="+id;
    }


}