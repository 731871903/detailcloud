package com.yc.Lwc.consumer.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Liweicheng
 * @create 2020/10/9 - 21:25
 */
@SpringBootConfiguration
public class appconfig {
    @Bean //创建一个 restTemplate 的模板操作对象
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
