package com.stranger.camping.campingzuul.controller;

import com.stranger.camping.campingzuul.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findbyid")
    public String findbyid(Integer id, Model model){
        Map map = productService.findbyid(id);

        Object product = map.get("product");
        ArrayList campFacilities =(ArrayList) map.get("campFacilities");
        Object seller = map.get("seller");

        model.addAttribute("product",product);
        model.addAttribute("seller",seller);
        model.addAttribute("campFacilities",campFacilities);

        return  "camping-detial";
    }



    @RequestMapping("/select")
    public String  select (String orderDesc,Long productId,Model model){
        String s=  productService.select(orderDesc,productId);
        model.addAttribute("s",s);
        return  "buy";
    }
}
