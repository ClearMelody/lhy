package com.stranger.camping.campingproductclient.service;


import com.stranger.camping.campingproductclient.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllByEs(String productName,Long typeId);
}
