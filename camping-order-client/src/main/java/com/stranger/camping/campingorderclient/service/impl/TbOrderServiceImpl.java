package com.stranger.camping.campingorderclient.service.impl;

import com.stranger.camping.campingorderclient.dao.TbOrderDao;
import com.stranger.camping.campingorderclient.model.TbOrder;
import com.stranger.camping.campingorderclient.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TbOrderServiceImpl implements TbOrderService {

    @Autowired
    private TbOrderDao tbOrderDao;

    @Override
    public List<TbOrder> findByUserId(Integer id) {
        Example example = new Example(TbOrder.class);
        if(id != null){

            example.and().andEqualTo("userId",id);
            List<TbOrder> tbOrders = tbOrderDao.selectByExample(example);
            return  tbOrders;
        }
        return null;
    }
}
