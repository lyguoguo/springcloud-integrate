package com.gly.springcloudlogback.web;

import com.alibaba.fastjson.JSON;
import com.gly.springcloudlogback.config.LogJson;
import com.gly.springcloudlogback.config.RequestConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudlogback.web
 * @date:2019/6/5
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private LogJson logJson;

    @PostMapping("/writeLog")
    public String writeLog(String requestParam, HttpServletRequest request){
        String responseMsg = "响应完成:"+requestParam;
        logger.info(logJson.writeLog(request,"XXXX",responseMsg));
        return responseMsg;
    }
}
