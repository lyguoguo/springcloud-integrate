package com.gly.springcloudkafka.producer;

import com.gly.springcloudkafka.bean.Response;
import com.gly.springcloudkafka.constants.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudkafka
 * @date:2019/5/6
 **/
@Slf4j
@Component
public class KafakaSender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public Response sendMessage(String message){
        log.info("kafka的消息:"+ message);
        kafkaTemplate.send("test", "key", message);
        log.info("发送kafka成功.");
        return new Response(ResultCode.SUCCESS, "发送kafka成功", null);
    }
}
