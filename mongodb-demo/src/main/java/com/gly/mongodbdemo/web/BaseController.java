package com.gly.mongodbdemo.web;

import com.gly.mongodbdemo.bean.Book;
import com.gly.mongodbdemo.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.mongodbdemo.web
 * @date:2019/6/12
 **/
@RestController
public class BaseController {
    @Autowired
    private MongoDbService mongoDbService;

    @PostMapping("/mongo/save")
    public String saveObj(@RequestBody Book book) {return mongoDbService.saveObj(book);}

    @GetMapping("/mongo/findAll")
    public List<Book> findAll() {return mongoDbService.findAll();}

    @GetMapping("/mongo/findOne")
    public Book findOne(@RequestParam String id) {return mongoDbService.getBookById(id);}

    @GetMapping("/mongo/findOneByName")
    public Book findOneByName(@RequestParam String name) {return mongoDbService.getBookByName(name);}

    @PostMapping("/mongo/update")
    public String update(@RequestBody Book book) {return mongoDbService.updateBook(book);}

    @PostMapping("/mongo/delOne")
    public String delOne(@RequestBody Book book) {return mongoDbService.deleteBook(book);}

    @GetMapping("/mongo/delById")
    public String delById(@RequestParam String id) {return mongoDbService.deleteBookById(id);}
}
