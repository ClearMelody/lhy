package com.stranger.camping.campingproductclient.service;

import com.stranger.camping.campingproductclient.dao.CampFacilitiesSonDao;
import com.stranger.camping.campingproductclient.model.CampFacilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampFacilitiesSonService {
    @Autowired
    private CampFacilitiesSonDao campFacilitiesSonDao;

    public List<CampFacilities> findallbyid(Integer id){
        List<CampFacilities> campFacilitiesList = campFacilitiesSonDao.findallbyid(id);
        return campFacilitiesList;
    }
}
