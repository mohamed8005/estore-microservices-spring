package com.example.kafkaservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "MessageTopic",groupId = "MessageTopicGroup")
    public void listenToTopic(String receivedMessage){
        System.out.println(
                receivedMessage
        );
    }
}
