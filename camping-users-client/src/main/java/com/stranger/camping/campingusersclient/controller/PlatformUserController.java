package com.stranger.camping.campingusersclient.controller;

import com.stranger.camping.campingusersclient.model.PlatformUser;
import com.stranger.camping.campingusersclient.service.PlatformUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatformUserController {
    @Autowired
    private PlatformUserService platformUserService;
    @RequestMapping("/select")
    public PlatformUser select(Long id){
        PlatformUser platformUser=  platformUserService.select(id);
        return  platformUser;
    }
}
