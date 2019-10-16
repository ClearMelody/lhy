package com.stranger.camping.campingribbon.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {
//    通过之前注入ioc容器的restTemplate来消费service-hi服务的“/hi”接口
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloError1")
    public String hello(String name){
        return restTemplate.getForObject("http://SERVICE-ORDER/hi?name=" + name, String.class);
  }
     public String helloError1(String name) {
         System.out.println("出现故障-------------------------------------------");
                    return "hi,"+name+",sorry,error!";
                }


    @HystrixCommand(fallbackMethod="helloError") //@HystrixCommand注解。
    public List findall() {
        return restTemplate.getForObject("http://SERVICE-ORDER/findall", List.class);
    }
    public List helloError() {
        List list=new ArrayList();
        list.set(1,"服务器出现故障，断开连接");
        System.out.println("出现故障------------------------------------------------------------------");
        return list;
    }


}

/*熔断器的作用：
这就说明当 service-hi 工程不可用的时候，service-ribbon调用 service-hi的API接口时，
会执行快速失败，直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞。
*/
