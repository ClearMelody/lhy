package com.stranger.camping.campingusersclient.dao;

import com.stranger.camping.campingusersclient.model.PlatformUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PlatformUserDao extends Mapper<PlatformUser> {
}
