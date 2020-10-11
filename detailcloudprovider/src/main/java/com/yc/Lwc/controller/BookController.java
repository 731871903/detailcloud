package com.yc.Lwc.controller;

import com.yc.Lwc.bean.Book;
import com.yc.Lwc.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

@GetMapping("{id}")
public Book getBook(@PathVariable("id") Integer id){
    return bookService.getBook(id);
}


@GetMapping("findAll")
public List<Book> findAll(){
    return bookService.findAll();
}
}
