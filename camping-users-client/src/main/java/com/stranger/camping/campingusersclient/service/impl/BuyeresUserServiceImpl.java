package com.stranger.camping.campingusersclient.service.impl;

import com.stranger.camping.campingusersclient.dao.BuyeresUserDao;
import com.stranger.camping.campingusersclient.model.BuyeresUser;
import com.stranger.camping.campingusersclient.service.BuyeresUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class BuyeresUserServiceImpl implements BuyeresUserService {
    @Autowired
    private BuyeresUserDao buyeresUserDao;


    @Override
    public BuyeresUser findByUserName(String loginName) {
        Example example = new Example(BuyeresUser.class);
        //判断是否为空值
        if(StringUtils.isNotBlank(loginName)){
            //判断是都包含又有@符号
            int i = loginName.indexOf("@");

            //假如有@符号就去根据邮箱字段查询
            if(i > 0){
                example.and().andEqualTo("email",loginName);
            }else {
                example.and().andEqualTo("telephoneNumber",loginName);
            }

            BuyeresUser buyeresUser = buyeresUserDao.selectOneByExample(example);

            return buyeresUser;
        }

        return null;
    }


    @Override
    public BuyeresUser findById(Integer id) {
        BuyeresUser buyeresUser = buyeresUserDao.selectByPrimaryKey(id);
        return buyeresUser;
    }
}
