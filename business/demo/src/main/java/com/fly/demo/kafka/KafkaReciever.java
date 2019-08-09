package com.fly.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *  
 *    
 *  @author liaoqinghui  
 *  @time 2019.08.09 11:29  
 */
@Component
public class KafkaReciever {


    @KafkaListener(topics = {"test.topic"})
    public void rec(ConsumerRecord<?, ?> record) {
        Object value = record.value();
        System.out.println(value);
    }


}
