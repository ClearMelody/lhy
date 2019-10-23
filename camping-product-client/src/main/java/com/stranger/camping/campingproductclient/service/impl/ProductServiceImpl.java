package com.stranger.camping.campingproductclient.service.impl;

import com.stranger.camping.campingproductclient.dao.CampTypeDao;
import com.stranger.camping.campingproductclient.dao.HouseTypeDao;
import com.stranger.camping.campingproductclient.dao.ProductDao;
import com.stranger.camping.campingproductclient.model.CampType;
import com.stranger.camping.campingproductclient.model.HouseType;
import com.stranger.camping.campingproductclient.model.Product;
import com.stranger.camping.campingproductclient.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private HouseTypeDao houseTypeDao;

    @Override
    public List<Product> findAllByEs(String productName,Long typeId) {
        Example example = new Example(Product.class);
            //模糊查询标题
            if(productName != null){
                example.and().andLike("productName","%"+productName+"%");
            }
            //根据营地类型查询
            if(typeId != null){
                example.and().andEqualTo("typeId",typeId);
            }

        List<Product> products = productDao.selectByExample(example);
        return products;
    }
}
