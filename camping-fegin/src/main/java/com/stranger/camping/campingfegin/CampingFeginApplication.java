package com.stranger.camping.campingfegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient   //向中心注册
@EnableDiscoveryClient  //可以被发现
@EnableFeignClients   //注解开启Feign的功能
@SpringBootApplication
public class CampingFeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampingFeginApplication.class, args);
    }

}
