package com.stranger.camping.campingproductclient.dao;

import com.stranger.camping.campingproductclient.model.HouseType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface HouseTypeDao extends Mapper<HouseType> {
    @Select(value = "select * from house_type where prouduct_id=#{id}")
     List<HouseType> findbysellid(Integer id);
}
