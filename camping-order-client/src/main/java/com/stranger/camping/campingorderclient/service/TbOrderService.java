package com.stranger.camping.campingorderclient.service;

import com.stranger.camping.campingorderclient.model.TbOrder;

import java.util.List;

public interface TbOrderService {

    List<TbOrder> findByUserId(Integer id);

}
