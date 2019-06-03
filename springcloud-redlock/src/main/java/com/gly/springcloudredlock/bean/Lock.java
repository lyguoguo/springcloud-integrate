package com.gly.springcloudredlock.bean;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudredlock.bean
 * @date:2019/6/3
 **/
public class Lock {
    private String name;
    private String value;

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}
