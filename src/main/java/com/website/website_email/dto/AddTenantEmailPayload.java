package com.website.website_email.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString
@NoArgsConstructor
public class AddTenantEmailPayload extends EmailPayload {
    private String urlToResetPassword;

    @Override
    public EmailType getEmailType() {
        return EmailType.ADD_TENANT;
    }
}
