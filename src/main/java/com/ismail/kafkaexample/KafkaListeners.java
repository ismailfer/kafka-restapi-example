package com.ismail.kafkaexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListeners
{
    int receiveCount = 0;

    @KafkaListener(topics = "kafkaexample", groupId = "groupId", containerFactory = "messageFactory")
    //@KafkaListener(topics = "kafkaexample", groupId = "groupId")
    void listener(Message message)
    {
        receiveCount += 1;

        // only print after 10,000 msgs received
        //if (receiveCount == 1 || receiveCount % 10000 == 0)
        System.out.println("Listener received #" + (receiveCount) + ": " + message);
    }
}
