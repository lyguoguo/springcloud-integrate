package com.gly.springbootelasticsearch.service.impl;

import com.alibaba.fastjson.JSON;
import com.gly.springbootelasticsearch.entity.Item;
import com.gly.springbootelasticsearch.repository.ItemRepository;
import com.gly.springbootelasticsearch.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springbootelasticsearch.service.impl
 * @date:2019/6/10
 **/
@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public void insert(Item item) {
        Item result = itemRepository.save(item);
        log.info("保存成功：{}", JSON.toJSONString(result));
    }

    @Override
    public void insertList(List<Item> itemList) {
        itemRepository.saveAll(itemList);
    }

    @Override
    public void update(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Iterable<Item> findAll(Sort sort) {
        return itemRepository.findAll(sort);
    }

    @Override
    public Page<Item> search(NativeSearchQuery build) {
        return itemRepository.search(build);
    }
}
