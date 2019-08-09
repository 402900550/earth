package com.fly.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

/**
 *  
 *    kafka还没配置完不能启用
 *  @author liaoqinghui  
 *  @time 2019.08.09 11:26  
 */
@RestController
public class TestController22 {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @GetMapping("kaSend")
    public void kafkaSend(){

        kafkaTemplate.send("test.topic", JSON.toJSONString("hello kafka!"));


        Connection connection=null;


    }

}
