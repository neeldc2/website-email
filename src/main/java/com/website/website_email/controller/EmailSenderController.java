package com.website.website_email.controller;

import com.website.website_email.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class EmailSenderController {

    private final EmailService emailService;

    @PostMapping("/send")
    public void sendEmail() {
        emailService.sendSimpleMessage(
                "neeldc2@gmail.com",
                "Welcome",
                "THIS IS A TEST MESSAGE"
        );
    }

    @PostMapping("/send2")
    public void sendEmail2() {
        emailService.sendMessageWithAttachment(
                "neeldc2@gmail.com",
                "Welcome",
                "THIS IS A TEST MESSAGE",
                ""
        );
    }
}
