package com.vinson.controller;

import com.vinson.component.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("测试生产者发送消息");
        kafkaProducer.sendMessage();
        return "kafka消息已发送";
    }
}
