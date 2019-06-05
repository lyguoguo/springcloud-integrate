package com.gly.springcloudlogback.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudlogback.config
 * @date:2019/6/5
 **/
@Component
public class LogJson {

    private RequestConvert requestConvert;

    public LogJson() {
        requestConvert = new RequestConvert();
    }

    public String writeLog(HttpServletRequest request){
        return writeLog(request,"","");
    }
    public String writeLog(HttpServletRequest request,String message){
        return writeLog(request,message,"");
    }

    public String writeLog(HttpServletRequest request,String message,String response){
        return requestConvert.convert(request,message,response);
    }
}
