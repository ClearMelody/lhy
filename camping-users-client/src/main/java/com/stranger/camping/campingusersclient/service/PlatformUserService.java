package com.stranger.camping.campingusersclient.service;

import com.stranger.camping.campingusersclient.dao.PlatformUserDao;
import com.stranger.camping.campingusersclient.model.PlatformUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformUserService {
    @Autowired
    private PlatformUserDao platformUserDao;
    public PlatformUser select(Long id) {
        PlatformUser platformUser = platformUserDao.selectByPrimaryKey(id);
        return platformUser;
    }
}
