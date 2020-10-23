package com.yc.Lwc.controller;

import com.yc.Lwc.bean.Book;
import com.yc.Lwc.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liweicheng
 * @create 2020/10/8 - 14:34
 */
@RestController
@RequestMapping("book")
public class BookController {
@Autowired
private BookService bookService;
@Resource
private DiscoveryClient discoveryClient;   //注意要导入springframework中的接口
@GetMapping("{id}")
public Book getBook(@PathVariable("id") Integer id){
    return bookService.getBook(id);
}


@GetMapping("findAll")
public List<Book> findAll(){
    show();
    return bookService.findAll();
}

@RequestMapping("/discover")
public Object discover(){
        System.out.println( this.discoveryClient.description() );
        System.out.println(  ((EurekaDiscoveryClient)this.discoveryClient).getServices());
        //再通过Service获取EurekaServiceInstance
        return this.discoveryClient;
    }

    private void show(){
        System.out.println( this.discoveryClient.description() );

        //EurekaDiscoveryClient
        EurekaDiscoveryClient edc=(EurekaDiscoveryClient)this.discoveryClient;
        // 服务器上有有很多服务
        List<String> servicesName=edc.getServices();
        for( String sn:servicesName ){
            System.out.println("服务名:"+ sn );
            List<ServiceInstance> instances=edc.getInstances(  sn );
            for(  ServiceInstance si:instances ){
                System.out.println(  si.getScheme()+" "+  si.getHost() +" "+si.getPort()+" "+ si.getUri()  );
            }
        }
    }
}
