package com.stranger.camping.campingorderclient.service;

import com.stranger.camping.campingorderclient.dao.TbOrderDao;
import com.stranger.camping.campingorderclient.model.TbOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TbOrderService {
    @Autowired
    private TbOrderDao tbOrderDao;
    public  void insert(TbOrder tbOrder){
        int insert = tbOrderDao.insert(tbOrder);
        System.out.println(insert);
    }

    public String  select(TbOrder tbOrder){
        Example example = new Example(TbOrder.class);
        example.and().andEqualTo("orderDesc", tbOrder.getOrderDesc());
        example.and().andEqualTo("productId", tbOrder.getProductId());
        List<TbOrder> tbOrders = tbOrderDao.selectByExample(example);
        if (tbOrders!=null){
            return "本次抢购成功";
        }
        return "本次抢购失败";
    }
}
