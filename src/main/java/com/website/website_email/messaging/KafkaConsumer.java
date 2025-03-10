package com.website.website_email.messaging;

import org.springframework.kafka.annotation.KafkaListener;

import static com.website.website_email.constant.WebsiteEmailConstant.KafkaConstants.NOTIFICATION_EMAIL_TOPIC;
import static com.website.website_email.constant.WebsiteEmailConstant.KafkaConstants.NOTIFICATION_EMAIL_TOPIC_CONSUMER_GROUP;

//@Service
public class KafkaConsumer {

    @KafkaListener(
            topics = NOTIFICATION_EMAIL_TOPIC,
            groupId = NOTIFICATION_EMAIL_TOPIC_CONSUMER_GROUP,
            concurrency = "2"
    )
    public void listen(String message) {
        System.out.println("Received message: " + message);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Received message: " + message);
    }
}
