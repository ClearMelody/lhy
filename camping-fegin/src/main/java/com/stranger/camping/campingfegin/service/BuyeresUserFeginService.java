package com.stranger.camping.campingfegin.service;


import com.stranger.camping.campingfegin.model.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
//通过@ FeignClient（“服务名”），来指定调用哪个逻辑服务ip和端口
@FeignClient(value = "service-users", fallback = BuyeresUserServiceHystrix.class)//加入熔断机制后，服务名一起写进去了
public interface BuyeresUserFeginService {
    //根据注册用户名查询是否有账号
    @RequestMapping("/user/findName")
    JsonResult findByName(@RequestParam(value = "loginName") String loginName);

    @RequestMapping("/user/findById")
    JsonResult findById(@RequestParam(value = "id") Integer id);


}



@Component
class BuyeresUserServiceHystrix implements BuyeresUserFeginService{

    @Override
    public JsonResult findByName(String loginName) {
        return JsonResult.createFailJsonResult("200200200","访问出错");
    }

    @Override
    public JsonResult findById(Integer id) {
        return JsonResult.createFailJsonResult("200300200","访问出错");
    }

}
