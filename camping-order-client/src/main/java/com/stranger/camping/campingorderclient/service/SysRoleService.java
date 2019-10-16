package com.stranger.camping.campingorderclient.service;

import com.stranger.camping.campingorderclient.dao.SysRoleDao;
import com.stranger.camping.campingorderclient.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    public List<SysRole> findall(){
        List<SysRole> sysRoles = sysRoleDao.selectAll();
        return sysRoles;
    }
}
