package com.gly.springcloudakka.akka.bean;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudakka
 * @date:2019/5/6
 **/
public class AkkaReq {

    private String data;

    public AkkaReq(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
