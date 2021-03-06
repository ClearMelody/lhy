package com.stranger.camping.campingzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication //springboot注解
@EnableZuulProxy   //开启zuul的功能：
@EnableEurekaClient //向中心注册
@EnableDiscoveryClient //向中心注册可以被发现
@EnableFeignClients   //注解开启Feign的功能
public class CampingZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampingZuulApplication.class, args);
    }

}
