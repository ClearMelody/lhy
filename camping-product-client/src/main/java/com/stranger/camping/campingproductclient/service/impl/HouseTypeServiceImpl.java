package com.stranger.camping.campingproductclient.service.impl;

import com.stranger.camping.campingproductclient.dao.HouseTypeDao;
import com.stranger.camping.campingproductclient.model.HouseType;
import com.stranger.camping.campingproductclient.service.HouseTypeSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseTypeServiceImpl implements HouseTypeSercice {
    @Autowired
    private HouseTypeDao houseTypeDao;

    @Override
    public List<HouseType> findByProductId() {
        List<HouseType> houseTypes = houseTypeDao.selectAll();
        return houseTypes;
    }
}
