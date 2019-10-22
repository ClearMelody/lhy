package com.stranger.camping.campingribbon.controller;

import com.stranger.camping.campingribbon.service.ProductService;
import com.stranger.camping.campingribbon.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SellerService sellerService;
    @RequestMapping("/findbyid")
    public Map findbyid(int id){
        Map map = productService.findbyid(id);
        Integer sellerId = (Integer)map.get("sellerId");
        //在开启一个服务路径，访问卖家信息
        Object seller = sellerService.select(sellerId);
        map.put("seller",seller);

        return  map;
    }
    @RequestMapping("/send")
    public String  send (String orderDesc, Long productId){
        String send = productService.send(orderDesc, productId);
        return send;

    }

    @RequestMapping("/select")
    public String  selectorder (String orderDesc, Long productId){
        String s=  productService.selectorder(orderDesc,productId);
        return  s;
    }
}
