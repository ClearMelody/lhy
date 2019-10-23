package com.stranger.camping.campingfegin.controller;

import com.stranger.camping.campingfegin.model.JsonResult;
import com.stranger.camping.campingfegin.service.HouseTypeFeignService;
import com.stranger.camping.campingfegin.service.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/house")
public class HouseTypeFeignController {

    @Autowired
    private ProductFeignService productFeignService;

    @RequestMapping("/findAll")
    public JsonResult findByProductId(){
        return productFeignService.findByProductId();
    }

}
