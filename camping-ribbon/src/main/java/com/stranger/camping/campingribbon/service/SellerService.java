package com.stranger.camping.campingribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SellerService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod="Error") //@HystrixCommand注解。
    public Object select(Integer id) {
        return restTemplate.getForObject("http://SERVICE-USERS/select?id="+id, Object.class);
    }

    public Object Error(Integer id) {
        Map map=new HashMap();
        map.put("抱歉你妹的","服务器故障,无法查询");
        return map;
    }

}
