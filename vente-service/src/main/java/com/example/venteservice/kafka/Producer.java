package com.example.venteservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public  void  sendMessageToTopic(String message){
        kafkaTemplate.send("UpdateProductTopic",message);
    }
}
