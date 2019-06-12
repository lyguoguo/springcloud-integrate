package com.gly.mongodbdemo.dao;

import com.gly.mongodbdemo.bean.Book;
import org.springframework.stereotype.Repository;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.mongodbdemo.dao
 * @date:2019/6/12
 **/
@Repository
public class BookMongoDbDao extends MongoDbDao<Book> {
    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }
}
