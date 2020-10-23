package com.yc.Lwc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Liweicheng
 * @create 2020/10/11 - 20:38
 */

@SpringBootApplication
@EnableEurekaServer   //启用 eureka服务器
public class Eureka2App {
    public static void main(String[] args) {
        SpringApplication.run(  Eureka2App.class, args );
    }
}
