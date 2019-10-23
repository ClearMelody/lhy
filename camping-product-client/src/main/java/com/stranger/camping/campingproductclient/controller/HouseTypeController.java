package com.stranger.camping.campingproductclient.controller;

import com.stranger.camping.campingproductclient.dao.HouseTypeDao;
import com.stranger.camping.campingproductclient.model.HouseType;
import com.stranger.camping.campingproductclient.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseTypeController {
    @Autowired
    private HouseTypeDao houseTypeDao;

    @RequestMapping("/findAll")
    public JsonResult findByProductId(){

        List<HouseType> houseTypes = houseTypeDao.selectAll();

        return JsonResult.createSuccessJsonResult(houseTypes);
    }
}
