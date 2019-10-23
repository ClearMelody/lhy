package com.stranger.camping.campingfegin.controller;

import com.stranger.camping.campingfegin.model.JsonResult;
import com.stranger.camping.campingfegin.service.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductFeignController {
    @Autowired
    private ProductFeignService productFeignService;

    @RequestMapping("/findAllByEs")
    public JsonResult findAllByEs(@RequestParam(value = "productName",required = false) String productName, @RequestParam(value = "typeId",required = false) Long typeId){
        return productFeignService.findAllByEs( productName,typeId);
    }
}
