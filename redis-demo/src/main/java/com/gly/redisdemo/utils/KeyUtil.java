package com.gly.redisdemo.utils;

import java.util.Random;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.redisdemo.utils
 * @date:2019/6/13
 **/
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String getUniqueKey(){//加一个锁
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;//随机六位数
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
