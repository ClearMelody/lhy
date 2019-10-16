package com.stranger.camping.campingorderclient.controller;

import com.stranger.camping.campingorderclient.model.SysRole;
import com.stranger.camping.campingorderclient.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @RequestMapping("/findall")
    public List<SysRole> findall(){
        return sysRoleService.findall();
    }
}
