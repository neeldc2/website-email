package com.website.website_email.service;

import com.website.website_email.dto.EmailPayload;
import com.website.website_email.dto.EmailType;

public interface EmailScenario<T extends EmailPayload> {
    EmailType getEmailType();

    void send(T emailPayload);
}
