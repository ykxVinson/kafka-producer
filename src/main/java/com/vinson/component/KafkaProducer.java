package com.vinson.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /*
    发送消息
     */
    public void sendMessage() {
        String message = "Hello world vinson";
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send("test1", "hello", message);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("sendMessage error");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("SendMessage success");
            }
        });
    }
}
