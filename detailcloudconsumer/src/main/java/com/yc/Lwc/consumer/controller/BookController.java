package com.yc.Lwc.consumer.controller;

import com.yc.Lwc.consumer.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liweicheng
 * @create 2020/10/8 - 14:34
 */
@RestController
@RequestMapping("/consumer")
public class BookController {
@Autowired
private RestTemplate restTemplate;

@Resource
private LoadBalancerClient loadBalancerClient;//因为ribbon是客户端负载均衡，所以他可以在客户端记录访问的日志

@Autowired
private HttpHeaders httpHeaders;

//直接访问eureka中的服务名即可,这样 ribbon会拉取到服务实例列表，再利用负载均衡算法获取一个服务.
private static String RestURL="http://DETAILCLOUDPROVIDE/";//访问服务



@GetMapping("{id}")
public Book getBook(@PathVariable("id") Integer id){
//    return  restTemplate.getForObject( URL+id, Book.class);
    //   HttpEntity(    MultiValueMap)   ,    HttpHeaders: MultiValueMap
    //   返回: ResponseEntity
    ServiceInstance serviceInstance=this.loadBalancerClient.choose(RestURL);
    String ip=serviceInstance.getHost();
    int port=serviceInstance.getPort();

    System.out.println("【***服务提供实例信息***】host="+ip
        +"、port="+port
            +"、serviceId="+serviceInstance.getServiceId()
    );

    return restTemplate.exchange( RestURL+"book/"+id, HttpMethod.GET, new HttpEntity<Object>(  httpHeaders   ), Book.class ).getBody();
}




@GetMapping("/findAll")
public List<Book> findAll(){
//    return restTemplate.getForObject(URL+"findALl",List.class);
    return restTemplate.exchange(RestURL+"book/"+"findAll",HttpMethod.GET, new HttpEntity<Object>(  httpHeaders ), List.class).getBody();
}
}
