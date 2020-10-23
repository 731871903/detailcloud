package com.yc.Lwc.robinConfiguration;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @author Liweicheng
 * @create 2020/10/23 - 22:36
 */
//此类暂时不会被spring托管
public class RobinConfigure {

    @Bean
    public IRule ribbonRule(){
        return new com.netflix.loadbalancer.RandomRule();
    }
}
