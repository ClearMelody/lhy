package com.stranger.camping.campingusersclient.service;

import com.stranger.camping.campingusersclient.model.BuyeresUser;

public interface BuyeresUserService {

    BuyeresUser findByUserName(String loginName);

    BuyeresUser findById(Integer id);
}
