package com.yc.Lwc.consumer.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author Liweicheng
 * @create 2020/10/9 - 21:25
 */
@SpringBootConfiguration
public class appconfig {

    //restTemplate由spring容器托管
    @Bean //创建一个 restTemplate 的模板操作对象
    @LoadBalanced   //加入负载均衡，此处负载均衡是全局配置        使用AOP切面拦截器拦截请求，实现负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeaders(){
        HttpHeaders headers= new HttpHeaders();
        String auth="admin:a";//认证的原始用户名和密码
        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); //加密处理
        String authHeader="Basic "+new String(encodeAuth);
        headers.set("Authorization",authHeader);    //    Http请求头         Authorization: Base xxxxxxxxx
        return headers;
    }


    @Bean//由spring托管，则这个消费端都会采用这种负载均衡
    public IRule ribbonRule(){//其中IRule就是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule();//随机访问的策略
    }
}
