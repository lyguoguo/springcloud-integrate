package com.gly.springcloudprometheus.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudprometheus.web
 * @date:2019/5/17
 **/
@Slf4j
@RestController
public class HomeController {
    @RequestMapping("/endpointA")
    public void handlerA() throws InterruptedException {
        log.info("/endpointA");
        Thread.sleep(RandomUtils.nextLong(0, 100));
    }

    @RequestMapping("/endpointB")
    public void handlerB() throws InterruptedException {
        log.info("/endpointB");
        Thread.sleep(RandomUtils.nextLong(0, 100));
    }
}
