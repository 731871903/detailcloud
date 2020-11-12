package com.yc.Lwc.service;

import com.yc.Lwc.bean.Book;
import com.yc.Lwc.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


//此处接口中的方法与服务提供方的功能( ProductController )一致
//即将 Rest的调用转为了接口中方法的调用. 这个接口中的调用要与提供方的服务要完全一样.
@FeignClient(name="DETAILCLOUDPROVIDE", configuration = FeignClientConfig.class,fallbackFactory = IProductClientServiceFallbackFactory.class)  // 配置要按自定义的类FeignClientConfig
public interface IProductClientService {

    @RequestMapping("/book/get/{id}") //这个springMVC的调用地址要与服务提供方要求的完全一样
    public Book get(@PathVariable("id")int id);

    @RequestMapping("/book/get/findAll")
    public List<Book> list() ;



}
