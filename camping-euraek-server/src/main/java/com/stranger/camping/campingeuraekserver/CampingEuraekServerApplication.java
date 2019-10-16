package com.stranger.camping.campingeuraekserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableEurekaClient  //注册
@EnableDiscoveryClient  //发现
@EnableEurekaServer    //服务中心
@SpringBootApplication
public class CampingEuraekServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampingEuraekServerApplication.class, args);
    }


    @EnableWebSecurity

    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable(); //关闭csrf
            super.configure(http);

        }
    }
}