package com.website.website_email.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.website_email.dto.EmailPayload;
import com.website.website_email.service.EmailScenario;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.website.website_email.constant.WebsiteEmailConstant.ActiveMqConstants.EMAIL_QUEUE;

@Component
@RequiredArgsConstructor
public class EmailActiveMqConsumer {

    private final ObjectMapper objectMapper;
    private final List<EmailScenario> emailScenarios;

    @JmsListener(destination = EMAIL_QUEUE)
    public void receiveMessage(final String emailPayloadJson) {
        try {
            EmailPayload emailPayload = objectMapper.readValue(
                    emailPayloadJson, EmailPayload.class);

            emailScenarios.stream()
                    .filter(emailScenario -> emailScenario.getEmailType() == emailPayload.getEmailType())
                    .findFirst()
                    .ifPresent(emailScenario -> emailScenario.send(emailPayload));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
