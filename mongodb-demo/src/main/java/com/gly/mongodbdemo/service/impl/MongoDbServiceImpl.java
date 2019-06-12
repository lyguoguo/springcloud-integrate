package com.gly.mongodbdemo.service.impl;

import com.gly.mongodbdemo.bean.Book;
import com.gly.mongodbdemo.dao.BookMongoDbDao;
import com.gly.mongodbdemo.service.MongoDbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.mongodbdemo.service.impl
 * @date:2019/6/12
 **/
@Slf4j
@Service
public class MongoDbServiceImpl implements MongoDbService {

    @Autowired
    private BookMongoDbDao bookMongoDbDao;

    /**
     * 保存对象
     *
     * @param book
     * @return
     */
    @Override
    public String saveObj(Book book) {
        log.info("--------------------->[MongoDB save start]");
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        bookMongoDbDao.save(book);
        return "添加成功";
    }


    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Book> findAll() {
        log.info("--------------------->[MongoDB find start]");
//        return mongoTemplate.findAll(Book.class);
        return bookMongoDbDao.queryList(new Book());
    }


    /***
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Book getBookById(String id) {
        log.info("--------------------->[MongoDB find start]");
       /* Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Book.class);*/
       Book filter = new Book();
       filter.setId(id);
       return bookMongoDbDao.queryOne(filter);
    }

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    @Override
    public Book getBookByName(String name) {
        log.info("--------------------->[MongoDB find start]");
       /* Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Book.class);*/
       Book filter = new Book();
        filter.setName(name);
       return bookMongoDbDao.queryOne(filter);
    }

    /**
     * 更新对象
     *
     * @param book
     * @return
     */
    @Override
    public String updateBook(Book book) {
        log.info("--------------------->[MongoDB update start]");
//        Query query = new Query(Criteria.where("_id").is(book.getId()));
//        Update update = new Update().set("publish", book.getPublish())
//                .set("info", book.getInfo())
//                .set("updateTime", new Date());
        //updateFirst 更新查询返回结果集的第一条
//        mongoTemplate.updateFirst(query, update, Book.class);
        //updateMulti 更新查询返回结果集的全部
//        mongoTemplate.updateMulti(query,update,Book.class);
        //upsert 更新对象不存在则去添加
//        mongoTemplate.upsert(query,update,Book.class);


        Book sourFilter = new Book();
        sourFilter.setId(book.getId());
        book.setUpdateTime(new Date());
        bookMongoDbDao.updateFirst(sourFilter,book);
        return "success";
    }

    /***
     * 删除对象
     * @param book
     * @return
     */
    @Override
    public String deleteBook(Book book) {
        log.info("--------------------->[MongoDB delete start]");
//        mongoTemplate.remove(book);
        bookMongoDbDao.delete(book);
        return "success";
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public String deleteBookById(String id) {
        log.info("--------------------->[MongoDB delete start]");
        //findOne
        Book book = getBookById(id);
        //delete
        deleteBook(book);
        return "success";
    }
}
