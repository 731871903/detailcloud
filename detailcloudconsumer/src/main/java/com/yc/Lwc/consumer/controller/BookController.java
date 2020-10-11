package com.yc.Lwc.consumer.controller;

import com.yc.Lwc.consumer.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Liweicheng
 * @create 2020/10/8 - 14:34
 */
@RestController
@RequestMapping("consumer")
public class BookController {
@Autowired
private RestTemplate restTemplate;

private static String URL="http://localhost:8888/book/";

@GetMapping("{id}")
public Book getBook(@PathVariable("id") Integer id){
    return  restTemplate.getForObject( URL+id, Book.class);
}


@GetMapping("all")
public List<Book> findAll(){
    return restTemplate.getForObject(URL+"findALl",List.class);
}
}
