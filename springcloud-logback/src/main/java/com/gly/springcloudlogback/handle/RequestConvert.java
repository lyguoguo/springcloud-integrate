package com.gly.springcloudlogback.handle;

import com.alibaba.fastjson.JSON;
import com.gly.springcloudlogback.utils.HttpUtil;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudlogback.convert
 * @date:2019/6/5
 **/
public class RequestConvert {

    //可选
    public String clientIp;
    //可选
    private String agent;
    //必填
    private Map<String,Object> head;
    //必填
    private String path;
    //必填
    private String method;
    //必填
    private Map<String, Object> params;
    //可选
    private String httpstatus;
    //必填
    private String response;
    //必填
    private Map<String, Object> message;

    public static RequestConvert build() {
        return new RequestConvert();
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

    public Map<String,Object> getHead() {
        return head;
    }

    public void setHead(Map<String,Object> head) {
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

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
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

    public Map<String, Object> getMessage() {
        return message;
    }

    public void setMessage(Map<String, Object> message) {
        this.message = message;
    }

    public RequestConvert addRequest(HttpServletRequest request){
        if(null != request){
            this.clientIp = HttpUtil.parseClientIp(request);
            this.head = HttpUtil.getRequestHead(request);
            this.path = request.getRequestURI();
            this.method = request.getMethod();
            this.params = HttpUtil.parseAttributes(request);
        }
        return this;
    }

    public RequestConvert addMessage(Map<String, Object> message){
        if(!CollectionUtils.isEmpty(message)){
            this.message = message;
        }
        return this;
    }

    public RequestConvert addResponse(String response){
        if(!StringUtils.isEmpty(response)){
            this.response = response;
        }
        return this;
    }

    public String convertToString() {
        this.agent = "web";
        return JSON.toJSONString(this);
    }
}
