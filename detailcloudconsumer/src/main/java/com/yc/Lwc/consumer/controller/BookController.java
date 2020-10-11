package com.yc.Lwc.consumer.controller;

import com.yc.Lwc.consumer.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

@Autowired
private HttpHeaders httpHeaders;

private static String URL="http://localhost:8888/book/";

@GetMapping("{id}")
public Book getBook(@PathVariable("id") Integer id){
//    return  restTemplate.getForObject( URL+id, Book.class);
    //   HttpEntity(    MultiValueMap)   ,    HttpHeaders: MultiValueMap
    //   返回: ResponseEntity
    return restTemplate.exchange( URL+id, HttpMethod.GET, new HttpEntity<Object>(  httpHeaders   ), Book.class ).getBody();
}




@GetMapping("/findAll")
public List<Book> findAll(){
//    return restTemplate.getForObject(URL+"findALl",List.class);
    return restTemplate.exchange(URL+"findAll",HttpMethod.GET, new HttpEntity<Object>(  httpHeaders ), List.class).getBody();
}
}
