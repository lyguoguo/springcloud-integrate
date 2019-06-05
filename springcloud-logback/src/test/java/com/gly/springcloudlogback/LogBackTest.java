package com.gly.springcloudlogback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudlogback
 * @date:2019/6/5
 **/
public class LogBackTest extends SpringcloudLogbackApplicationTests{

    private Logger logger = LoggerFactory.getLogger(LogBackTest.class);

    @Test
    public void LogTest(){
        logger.info("测试日志");
    }
}
