package com.stranger.camping.campingproductclient.dao;

import com.stranger.camping.campingproductclient.model.CampType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CampTypeDao extends Mapper<CampType> {
}
