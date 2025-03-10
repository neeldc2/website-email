package com.website.website_email.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class WebsiteEmailConstant {

    public static class KafkaConstants {
        public static final String NOTIFICATION_EMAIL_TOPIC = "notifications-email";
        public static final String NOTIFICATION_EMAIL_TOPIC_CONSUMER_GROUP = "notifications-email-consumer-group";
    }

}
