package com.stranger.camping.campingribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod="Error") //@HystrixCommand注解。
    public Map findbyid(int id) {
        return restTemplate.getForObject("http://SERVICE-PRODUCT/product/findbyid?id="+id, Map.class);
    }
    public Map Error(int id) {
        Map map=new HashMap();
        map.put("抱歉","服务器故障,无法查询");
        return map;
    }

    @HystrixCommand(fallbackMethod="Error1") //@HystrixCommand注解。
    public String selectorder(String orderDesc, Long productId) {
        return restTemplate.getForObject("http://SERVICE-ORDER/select?orderDesc="+orderDesc+"&productId="+productId, String.class);

    }
    public String Error1(String orderDesc, Long productId) {

        return "服务器故障,无法查询";
    }

    @HystrixCommand(fallbackMethod="Error2") //@HystrixCommand注解。
    public String send(String orderDesc, Long productId) {
        return restTemplate.getForObject("http://SERVICE-PRODUCT/send?name="+orderDesc+"&id="+productId, String.class);
    }
    public String Error2(String orderDesc, Long productId) {
        return "服务器故障,无法查询";
    }
}
