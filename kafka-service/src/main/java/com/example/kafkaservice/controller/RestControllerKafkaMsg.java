package com.example.kafkaservice.controller;

import com.example.kafkaservice.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class RestControllerKafkaMsg {

    @Autowired
    Producer producer;

    @GetMapping("/message/{message}")
    public void getMessageFromClient(@PathVariable String message){
        producer.sendMessageToTopic(message);
    }

}
