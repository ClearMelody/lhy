package com.stranger.camping.campingproductclient.dao;

import com.stranger.camping.campingproductclient.model.Product;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ProductDao extends Mapper<Product> {
}
