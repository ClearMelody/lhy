package com.stranger.camping.campingproductclient.dao;

import com.stranger.camping.campingproductclient.model.HouseType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface HouseTypeDao extends Mapper<HouseType> {
}
