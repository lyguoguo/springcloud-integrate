package com.gly.springcloudlogback.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudlogback.convert
 * @date:2019/6/5
 **/
@Component
public class LogJson {

    public LogJson() {
    }

    public String writeLog(HttpServletRequest request){
        return writeLog(request,null,"");
    }
    public String writeLog(HttpServletRequest request,Map<String,Object> message){
        return writeLog(request,message,"");
    }

    public String writeLog(HttpServletRequest request, Map<String,Object> message, String response){
        return RequestConvert.build().addRequest(request).addMessage(message).addResponse(response).convertToString();
    }
}
