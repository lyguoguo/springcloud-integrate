package com.gly.springcloudkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.springcloudkafka.consumer
 * @date:2019/5/6
 **/
@Slf4j
public class Listener {
    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("kafka的key: " + record.key());
        log.info("kafka的value: " + record.value().toString());
    }
}
