package com.stranger.camping.campingconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer  //注解开启配置服务器的功能
@EnableEurekaClient  //向中心注册
public class CampingConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampingConfigServerApplication.class, args);
    }

}
