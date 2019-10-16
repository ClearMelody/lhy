package com.stranger.camping.campingribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HelloService {
//    通过之前注入ioc容器的restTemplate来消费service-hi服务的“/hi”接口
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloError1") /*@HystrixCommand注解。
    @HystrixCommand(fallbackMethod = "helloError") /*@HystrixCommand注解。
                             该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法helloError()，
                             熔断方法直接返回了一个字符串
                                     */

    public String hello(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }          //在这里我们直接用的程序名SERVICE-HI/hi替代了具体的url地址，拼接上路径以此来访问逻辑业务，对该业务做负载均衡
                // 这说明当我们通过调用restTemplate.getForObject(“http://SERVICE-HI/hi?name=”+name,String.class)方法时，
                // 已经做了负载均衡，访问了不同的端口的服务实例。但是每个端口服务实例得到的结果是一致的，不要误解

    public List findall() {
        return restTemplate.getForObject("http://SERVICE-HI/findall", List.class);
    }

    public String helloError(String name) {
        return "hi,"+name+",sorry,error!";
    }

    public String helloError1(String name) {
        return "出现错误";
    }


}

/*熔断器的作用：
这就说明当 service-hi 工程不可用的时候，service-ribbon调用 service-hi的API接口时，
会执行快速失败，直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞。
*/
