package com.gly.springbootelasticsearch.service;

import com.gly.springbootelasticsearch.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

import java.util.List;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springbootelasticsearch.service
 * @date:2019/6/10
 **/
public interface ItemService {

    void insert(Item item);

    void insertList(List<Item> itemList);

    void update(Item item);

    Iterable<Item> findAll(Sort sort);

    Page<Item> search(NativeSearchQuery build);
}
