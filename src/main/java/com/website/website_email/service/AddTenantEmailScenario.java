package com.website.website_email.service;

import com.website.website_email.dto.AddTenantEmailPayload;
import com.website.website_email.dto.EmailType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddTenantEmailScenario implements EmailScenario<AddTenantEmailPayload> {

    @Override
    public EmailType getEmailType() {
        return EmailType.ADD_TENANT;
    }

    @Override
    public void send(AddTenantEmailPayload addTenantEmailPayload) {
        System.out.println(addTenantEmailPayload.getUrlToResetPassword());
    }

}
