package com.stranger.camping.campingorderclient.dao;

import com.stranger.camping.campingorderclient.model.TbOrder;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface TbOrderDao extends Mapper<TbOrder> {
}
