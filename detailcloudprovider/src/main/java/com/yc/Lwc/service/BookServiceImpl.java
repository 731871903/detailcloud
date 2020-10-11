package com.yc.Lwc.service;


import com.yc.Lwc.bean.Book;
import com.yc.Lwc.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liweicheng
 * @create 2020/10/8 - 14:28
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired(required = false)
    private BookMapper bookMapper;

    public Book getBook(Integer id){
        //根据主键查
        return bookMapper.selectByPrimaryKey(id);
    }



    public List<Book> findAll(){
        return bookMapper.selectAll();
    }
}
