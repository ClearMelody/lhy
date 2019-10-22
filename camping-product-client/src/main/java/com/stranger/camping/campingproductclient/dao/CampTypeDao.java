package com.stranger.camping.campingproductclient.dao;

import com.stranger.camping.campingproductclient.model.CampType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CampTypeDao extends Mapper<CampType> {
    @Select(value = "select ct.* from camp_type ct,product p where p.type_id = ct.id and  p.id=#{id}")
   CampType findbysellid(Integer id);
}
