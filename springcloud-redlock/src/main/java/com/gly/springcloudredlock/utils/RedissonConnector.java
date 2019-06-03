package com.gly.springcloudredlock.utils;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudredlock.utils
 *      获取RedissonClient连接类
 * @date:2019/6/3
 **/
@Component
public class RedissonConnector {

    RedissonClient redisson;

    @PostConstruct
    public void init(){
        redisson = Redisson.create();
    }

    public RedissonClient getClient(){
        return redisson;
    }
}
