package com.gly.mongodbdemo.service;

import com.gly.mongodbdemo.bean.Book;

import java.util.List;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.mongodbdemo.service
 * @date:2019/6/12
 **/
public interface MongoDbService {
    String saveObj(Book book);

    List<Book> findAll();

    Book getBookById(String id);

    Book getBookByName(String name);

    String updateBook(Book book);

    String deleteBook(Book book);

    String deleteBookById(String id);
}
