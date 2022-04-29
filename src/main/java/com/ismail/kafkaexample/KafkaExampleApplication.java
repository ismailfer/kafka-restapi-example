package com.ismail.kafkaexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class KafkaExampleApplication
{
    @Value("${kafka.topic}")
    private String kafkaTopic;

    public static void main(String[] args)
    {
        SpringApplication.run(KafkaExampleApplication.class, args);
    }

    @Bean
        // this method get called
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate)
    {
        return args -> {
            log.info("sending message to topic...");

            for (int i = 1; i <= 10; i++)
            {
                kafkaTemplate.send(kafkaTopic,
                        new Message("Hello Kafka " + i, LocalDateTime.now()));
            }
        };
    }
}
