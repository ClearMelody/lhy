package com.stranger.camping.campingproductclient.service;

import com.stranger.camping.campingproductclient.model.HouseType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HouseTypeSercice {

    List<HouseType> findByProductId();

}
