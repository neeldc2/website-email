package com.website.website_email.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.website_email.dto.AddTenantEmailPayload;
import com.website.website_email.dto.EmailPayload;
import com.website.website_email.dto.EmailType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class EmailPayloadDeserializer extends JsonDeserializer<EmailPayload> {

    private final ObjectMapper objectMapper;

    @Override
    public EmailPayload deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // Read the JSON as a tree
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String emailTypeString = node.get("emailType").asText();
        EmailType emailType = EmailType.fromString(emailTypeString);

        // Deserialize based on the emailType
        switch (emailType) {
            case ADD_TENANT:
                return objectMapper.treeToValue(node, AddTenantEmailPayload.class);
            default:
                throw new IllegalArgumentException("Unknown email type: " + emailType);
        }
    }
}
