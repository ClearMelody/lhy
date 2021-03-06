package com.stranger.camping.campingusersclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@EnableDiscoveryClient          //服务不需要发现
@SpringBootApplication
@EnableTransactionManagement // 配置的 事务注解的开发

@MapperScan(basePackages = "com.stranger.camping.campingusersclient.dao") // tkmapper的扫描
public class CampingUsersClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampingUsersClientApplication.class, args);
    }

}
