package com.stranger.camping.campingfegin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
//通过@ FeignClient（“服务名”），来指定调用哪个逻辑服务ip和端口
@FeignClient(value = "SERVICE-HI", fallback = HelloServiceHystrix.class)//加入熔断机制后，服务名一起写进去了
//@FeignClient("SERVICE-HI")//服务的名称（相当于IP和端口）
public interface HelloService {
    @RequestMapping("/hi")//来指定调用哪个逻辑服务controller的路径
    String hello(@RequestParam(value = "name") String name);


    @RequestMapping("/findall")//来指定调用哪个逻辑服务controller的路径
    List findall();
}

//熔断后进入该类，调用该方法
@Component
class HelloServiceHystrix implements HelloService {
    @Override
    public String hello(String name) {
        return "hello, name" + name + ", error";
    }

    @Override
    public List findall() {
        return null;
    }
}