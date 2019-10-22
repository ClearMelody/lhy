package com.stranger.camping.campingproductclient.controller;

import com.stranger.camping.campingproductclient.model.CampFacilities;
import com.stranger.camping.campingproductclient.model.Product;
import com.stranger.camping.campingproductclient.service.CampFacilitiesSonService;
import com.stranger.camping.campingproductclient.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    CampFacilitiesSonService campFacilitiesSonService;
    @RequestMapping("/findbyid")
    public Map findbyid(Integer id){
        Map map=new HashMap();
        Product product = productService.findbyid(id);
        Long sellerId = product.getSellerId();
        List<CampFacilities> campFacilities = campFacilitiesSonService.findallbyid(id);
        map.put("product",product);
        map.put("sellerId",sellerId);
        map.put("campFacilities",campFacilities);
        return  map;
    }

}
