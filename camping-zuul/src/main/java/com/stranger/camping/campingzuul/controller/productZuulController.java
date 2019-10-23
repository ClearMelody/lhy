package com.stranger.camping.campingzuul.controller;

import com.stranger.camping.campingzuul.model.JsonResult;
import com.stranger.camping.campingzuul.service.BuyeresUserZuulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/product")
public class productZuulController {

    @Autowired
    private BuyeresUserZuulService buyeresUserZuulService;


    @RequestMapping("/findAllByEs")
    public String findAllByEs(Model model, @RequestParam(value = "productName",required = false) String productName, @RequestParam(value = "typeId",required = false) Long typeId){
        //查询商品列表
        JsonResult jsonResult = buyeresUserZuulService.findAllByEs(productName,typeId);
        //查询房型列表
        JsonResult byProductId = buyeresUserZuulService.findByProductId();
        model.addAttribute("productName",productName);
        model.addAttribute("houses",byProductId.getResultData());
        model.addAttribute("products",jsonResult.getResultData());
        return "quarter";
    }
}
