package com.gly.mongodbdemo.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.mongodbdemo.bean
 * @date:2019/6/12
 **/
@Getter
@Setter
@ToString
public class Book {
    @Id
    private String id;
    //价格
    private Integer price;
    //书名
    private String name;
    //简介
    private String info;
    //出版社
    private String publish;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
