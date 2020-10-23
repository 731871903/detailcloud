package com.yc.Lwc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**、
 * @author Liweicheng
 * @create 2020/10/9 - 20:03
 */
@SpringBootApplication
@EnableEurekaClient //启动euraka客户端
@EnableDiscoveryClient//启动服务发现客户端，以获取当前provider的注册信息
public class LwcApp {
    public static void main(String[] args) {
        SpringApplication.run(LwcApp.class, args);
    }

}
