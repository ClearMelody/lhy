package com.stranger.camping.campingzuul.service;



import com.stranger.camping.campingzuul.model.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
//通过@ FeignClient（“服务名”），来指定调用哪个逻辑服务ip和端口
@FeignClient(value = "service-feign")//加入熔断机制后，服务名一起写进去了
public interface BuyeresUserZuulService {
    //根据注册用户名查询是否有账号
    @RequestMapping("/user/findName")
    JsonResult findByName(@RequestParam(value = "loginName") String loginName);

    @RequestMapping("/user/findById")
    JsonResult findById(@RequestParam(value = "id") Integer id);
    //根据用户id查询订单
    @RequestMapping("/order/findByUserId")
    JsonResult findByUserId(@RequestParam(value = "id") Integer id);
    //查询商品，及查全部商品
    @RequestMapping("/product/findAllByEs")
    JsonResult findAllByEs(@RequestParam(value = "productName",required = false) String productName, @RequestParam(value = "typeId",required = false) Long typeId);
    //查询所有的房型列表
    @RequestMapping("/house/findAll")
    JsonResult findByProductId();

}



