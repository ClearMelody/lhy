package com.stranger.camping.campingproductclient.dao;

import com.stranger.camping.campingproductclient.model.CampFacilities;
import com.stranger.camping.campingproductclient.model.CampFacilitiesSon;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CampFacilitiesSonDao extends Mapper<CampFacilitiesSon> {
//    @Select(value = "select * from camp_facilities cf ,camp_facilities_son cfs where cf.id=cfs.father_id and cfs.product_id=#{id}")
   List<CampFacilities> findallbyid(Integer id);
}

