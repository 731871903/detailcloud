package com.yc.Lwc.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liweicheng
 * @create 2020/10/26 - 21:25
 */
//关于Feign客户端的配置类
@Configuration
public class FeignClientConfig {
    //加入安全配置也属于
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin","b");
    }
}
