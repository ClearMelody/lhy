package com.stranger.camping.campingorderclient.controller;

import com.alibaba.fastjson.JSON;
import com.stranger.camping.campingorderclient.model.TbOrder;
import com.stranger.camping.campingorderclient.model.Util;
import com.stranger.camping.campingorderclient.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
@Autowired
private TbOrderService tbOrderService;
//抢购成功的商品存入订单表
    @RequestMapping("/insert")
    public void  insert (String s){
        Util util = JSON.parseObject(s, Util.class);
      TbOrder tbOrder=new TbOrder();
  tbOrder.setOrderDesc(util.getName());
  tbOrder.setProductId(util.getId());
        tbOrderService.insert(tbOrder);
    }
    //查询商品是否抢购成功
    @RequestMapping("/select")
    public String  select (String orderDesc,Long productId){
        TbOrder tbOrder=new TbOrder();
        tbOrder.setOrderDesc(orderDesc);
        tbOrder.setProductId(productId);
        String select = tbOrderService.select(tbOrder);
        return select;
    }

}
