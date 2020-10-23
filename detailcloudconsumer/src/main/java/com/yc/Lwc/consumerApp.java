package com.yc.Lwc;

import com.yc.Lwc.robinConfiguration.RobinConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author Liweicheng
 * @create 2020/10/9 - 20:37
 */
@SpringBootApplication
@EnableEurekaClient    //启用eureka客户端，这样能完成服务发现
//指定这个新的负载算法类给DETAILCLOUDPROVIDE这个服务用
//这里的name是服务的名称  如果需要有多个服务提供方。这个时候可以使用RibbonClient进行配置
//只对服务名为 DETAILCLOUDPROVIDE 下的服务清单采用RobinConfigure指定的负载均衡方式
@RibbonClient(name="DETAILCLOUDPROVIDE",configuration = RobinConfigure.class)
//如有多个服务要用不同的策略，则采用RobbinClients
//@RibbonClients
public class consumerApp {
    public static void main(String[] args) {
        SpringApplication.run(consumerApp.class, args);
    }
}
