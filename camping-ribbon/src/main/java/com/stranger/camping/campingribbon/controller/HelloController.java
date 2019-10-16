package com.stranger.camping.campingribbon.controller;


import com.stranger.camping.campingribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hellow(String name) {
      return   helloService.hello(name);
    }


    @RequestMapping("/findall")
    public List hellow() {
        return   helloService.findall();
    }

}
