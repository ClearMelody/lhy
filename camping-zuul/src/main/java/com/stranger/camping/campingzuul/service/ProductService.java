package com.stranger.camping.campingzuul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
public class ProductService {
    @Autowired
    private RestTemplate restTemplate;
    public Map findbyid(Integer id) {
        return restTemplate.getForObject("http://SERVICE-RIBBON/findbyid?id="+id, Map.class);
    }

    public String select(String orderDesc, Long productId) {
        return restTemplate.getForObject("http://SERVICE-RIBBON/select?orderDesc="+orderDesc+"&productId="+productId, String.class);
    }

    public String send(String orderDesc, Long productId) {
        return restTemplate.getForObject("http://SERVICE-RIBBON/send?orderDesc="+orderDesc+"&productId="+productId, String.class);
    }
}
