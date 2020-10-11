package com.yc.Lwc.service;


import com.yc.Lwc.bean.Book;

import java.util.List;

/**
 * @author Liweicheng
 * @create 2020/10/8 - 13:36
 */
public interface BookService {

    public Book getBook(Integer id);

    public List<Book> findAll();
}
