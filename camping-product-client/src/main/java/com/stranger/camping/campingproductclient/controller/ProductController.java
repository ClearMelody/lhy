package com.stranger.camping.campingproductclient.controller;

import com.stranger.camping.campingproductclient.model.JsonResult;
import com.stranger.camping.campingproductclient.model.Product;
import com.stranger.camping.campingproductclient.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAllByEs")
    public JsonResult findAllByEs(@RequestParam(value = "productName",required = false) String productName, @RequestParam(value = "typeId",required = false) Long typeId){

        List<Product> products = productService.findAllByEs(productName, typeId);

        return JsonResult.createSuccessJsonResult(products);

    }
}
