package com.stranger.camping.campingfegin.service;


import com.stranger.camping.campingfegin.model.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
//通过@ FeignClient（“服务名”），来指定调用哪个逻辑服务ip和端口
@FeignClient(value = "service-order", fallback = TbOrderFeignServiceImpl.class)//加入熔断机制后，服务名一起写进去了
public interface TbOrderFeignService {

    @RequestMapping("/order/findByUserId")
    JsonResult findByUserId(@RequestParam(value = "id") Integer id);
}

@Component
class TbOrderFeignServiceImpl implements TbOrderFeignService{


    @Override
    public JsonResult findByUserId(Integer id) {
        return JsonResult.createFailJsonResult("200200300","根据用户id查询用户订单错误,请解决");
    }
}
