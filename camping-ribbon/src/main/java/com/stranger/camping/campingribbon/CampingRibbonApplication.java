package com.stranger.camping.campingribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient//向中心注册
@EnableDiscoveryClient//可以被发现
@EnableHystrix    //注解开启Hystrix熔断器
@SpringBootApplication
public class CampingRibbonApplication {
    //    并且向程序的ioc注入一个bean: restTemplate;
// 并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CampingRibbonApplication.class, args);
    }

}
