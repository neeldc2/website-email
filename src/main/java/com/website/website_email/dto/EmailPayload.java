package com.website.website_email.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@AllArgsConstructor
@Data
@SuperBuilder
@NoArgsConstructor
//@JsonDeserialize(using = EmailPayloadDeserializer.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "emailType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AddTenantEmailPayload.class, name = "ADD_TENANT"),
})
public class EmailPayload {
    private Set<String> toEmailIds;
    private Set<String> ccEmailIds;
    private Set<String> bccEmailIds;
    private EmailType emailType;
}
