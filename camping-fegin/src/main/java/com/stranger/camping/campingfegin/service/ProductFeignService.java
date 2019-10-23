package com.stranger.camping.campingfegin.service;

import com.stranger.camping.campingfegin.model.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
//通过@ FeignClient（“服务名”），来指定调用哪个逻辑服务ip和端口
@FeignClient(value = "service-product", fallback = ProductFeignServiceImpl.class)
public interface ProductFeignService {
    @RequestMapping("/product/findAllByEs")
    JsonResult findAllByEs(@RequestParam(value = "productName",required = false) String productName, @RequestParam(value = "typeId",required = false) Long typeId);

    @RequestMapping("/house/findAll")
    JsonResult findByProductId();
}


@Component
class ProductFeignServiceImpl implements ProductFeignService{


    @Override
    public JsonResult findAllByEs(@RequestParam(value = "productName",required = false) String productName, @RequestParam(value = "typeId",required = false) Long typeId) {
        return JsonResult.createFailJsonResult("200300300","根据用户id查询用户订单错误,请解决");
    }

    @Override
    public JsonResult findByProductId() {
        return JsonResult.createFailJsonResult("200400100","网络错误");
    }
}