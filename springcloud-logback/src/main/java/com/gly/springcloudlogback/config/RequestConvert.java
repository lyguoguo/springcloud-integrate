package com.gly.springcloudlogback.config;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudlogback.config
 * @date:2019/6/5
 **/
public class RequestConvert {

    //可选
    public String clientIp;
    //可选
    private String agent;
    //必填
    private String head;
    //必填
    private String path;
    //必填
    private String method;
    //必填
    private String params;
    //可选
    private String httpstatus;
    //必填
    private String response;
    //必填
    private String message;

    public RequestConvert() {
        this.agent = "web";
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getHttpstatus() {
        return httpstatus;
    }

    public void setHttpstatus(String httpstatus) {
        this.httpstatus = httpstatus;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String convert(HttpServletRequest request,String message, String response){
        if(null != request){
            this.clientIp = request.getRemoteAddr()+":"+request.getRemotePort();
            this.head = getRequestHead(request);
            this.path = request.getServletPath();
            this.method = request.getMethod();
            this.params = (null==request.getParameterMap())?null:JSON.toJSONString(request.getParameterMap());
            this.response = response;
            this.message = message;
        }
        return JSON.toJSONString(this);
    }

    private String getRequestHead(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        Enumeration<String> headNames = request.getHeaderNames();
        while(headNames.hasMoreElements()) {
            String headName = headNames.nextElement();
            String headValue = request.getHeader(headName);
            map.put(headName,headValue);
        }
        return JSON.toJSONString(map);
    }
}
