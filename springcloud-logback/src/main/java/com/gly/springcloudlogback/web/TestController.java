package com.gly.springcloudlogback.web;

import com.gly.springcloudlogback.handle.LogJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
        logger.info(logJson.writeLog(request));

        Map<String,Object> message = new HashMap<>();
        message.put("haha","hahah");
        message.put("lala","lalal");
        logger.info(logJson.writeLog(request,message,responseMsg));
        return responseMsg;
    }
}
