package com.gly.springcloudkafka;

import com.gly.springcloudkafka.producer.KafakaSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudkafka
 * @date:2019/5/6
 **/
public class KafkaTest extends SpringcloudKafkaApplicationTests{

    @Autowired
    private KafakaSender kafakaSender;

    @Test
    public void sendMessage(){
        kafakaSender.sendMessage("我是一条kafka消息，你知道我的吗？？？？#￥……&&**");
    }
}
