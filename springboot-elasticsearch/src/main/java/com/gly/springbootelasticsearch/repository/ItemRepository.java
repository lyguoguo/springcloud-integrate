package com.gly.springbootelasticsearch.repository;

import com.gly.springbootelasticsearch.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springbootelasticsearch.repository
 * @date:2019/6/10
 **/
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
}
