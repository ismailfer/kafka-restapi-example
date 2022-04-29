package com.ismail.kafkaexample.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Slf4j
public class KafkaTopicConfig
{
    @Value("${kafka.topic}")
    private String kafkaTopic;

    /**
     * This will create a new topic
     *
     * @return
     */
    @Bean     // causes this class to be instantiated; and this method to be called on startup
    public NewTopic kafkaExampleTopic()
    {
        log.info("kafkaExampleTopic() called!");

        return TopicBuilder.name(kafkaTopic).build();
    }
}
