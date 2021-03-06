package com.gly.springcloudkafka.bean;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudkafka.bean
 * @date:2019/5/6
 **/
public class Response {
    private String code;
    private String message;
    private Object data;

    public Response(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
