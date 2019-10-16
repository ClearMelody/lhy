package com.stranger.camping.campingfegin.controller;


import com.stranger.camping.campingfegin.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelooController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name" ,required = false) String name) {
        return helloService.hello(name);
    }

    @RequestMapping("/findall")
    public List findall() {
        return helloService.findall();
    }
}
