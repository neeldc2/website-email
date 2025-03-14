package com.website.website_email.dto;


import org.springframework.util.StringUtils;

public enum EmailType {
    ADD_TENANT,
    ADD_USER;

    public static EmailType fromString(String emailTypeString) {
        if (!StringUtils.hasText(emailTypeString)) {
            throw new IllegalArgumentException("Email type cannot be null");
        }

        try {
            return EmailType.valueOf(emailTypeString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown email type: " + emailTypeString);
        }
    }
}
