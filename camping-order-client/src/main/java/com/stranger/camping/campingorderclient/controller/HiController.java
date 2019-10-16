package com.stranger.camping.campingorderclient.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class HiController {
    @Value("${server.port}") //变量的注入用@value, 对象用@Autowired
    private String port;
    @Value("${pass}")//从配置中心config server得到的pass，config server从远程中央仓库得到pass
    private String pass;
                                                        /*
                                                         码云上以键值对保存
                                                             test: root
                                                             pass: liuhanyu
                                                          */
    @RequestMapping("/hi")
    @ResponseBody
    public String home(@RequestParam(value = "name", defaultValue = "qf") String name) {//resful风格
        return "hi " + name + " ,i am from port:" + port+pass;
    }




}

