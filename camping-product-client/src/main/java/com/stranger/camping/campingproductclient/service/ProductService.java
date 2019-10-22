package com.stranger.camping.campingproductclient.service;

import com.stranger.camping.campingproductclient.dao.CampTypeDao;
import com.stranger.camping.campingproductclient.dao.ProductDao;
import com.stranger.camping.campingproductclient.model.CampType;
import com.stranger.camping.campingproductclient.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CampTypeDao campTypeDao;
    public Product findbyid(Integer id){
        //得到商品对象
        Product product = productDao.findbyid(id);
        //得到营地对象
        CampType campType = campTypeDao.findbysellid(id);
        product.setCampType(campType);
        return product;
    }

}
//    CREATE VIEW <视图名> AS <SELECT语句>