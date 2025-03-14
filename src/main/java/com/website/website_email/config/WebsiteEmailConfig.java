package com.website.website_email.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class WebsiteEmailConfig {

    @Value("${google-email-id}")
    private String googleEmailId;

    @Value("${google-app-password}")
    private String googleAppPassword;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(googleEmailId);
        mailSender.setPassword(googleAppPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        //props.put("mail.smtp.ssl.trust", "*");

        return mailSender;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Register modules for better Java 8+ support
        objectMapper.registerModule(new JavaTimeModule());    // Java 8 date/time types
        objectMapper.registerModule(new Jdk8Module());        // Java 8 features like Optional
        objectMapper.registerModule(new ParameterNamesModule()); // Better constructor handling

        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        // Date/time handling
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Null handling
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // Don't include null values

        // Error handling
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown properties
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true); // Handle unknown enum values

        // Precision features
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS); // Better precision for decimals

        // Output formatting
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty printing

        return objectMapper;
    }

}
