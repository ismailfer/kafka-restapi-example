package com.ismail.kafkaexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController
{
    private KafkaTemplate<String, Message> kafkaTemplate;

    @Value("${kafka.topic}")
    private String kafkaTopic;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest)
    {
        Message msg = new Message(messageRequest.message(), LocalDateTime.now());

        //kafkaTemplate.send("kafkaexample", messageRequest.message());

        kafkaTemplate.send(kafkaTopic, msg);
    }
}
