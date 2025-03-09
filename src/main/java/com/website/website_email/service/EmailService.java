package com.website.website_email.service;

import com.website.website_email.config.FreeMarkerConfig;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class EmailService {

    private final JavaMailSender emailSender;
    private final FreeMarkerConfig freeMarkerConfig;

    public void sendSimpleMessage(
            String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("website-email.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendMessageWithAttachment(
            String to, String subject, String text, String pathToAttachment) {

        MimeMessage message = emailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            message.setFrom("website-email.com");
            helper.setTo(to);
            helper.setSubject(subject);
            //helper.setText(text);

            // Process the FreeMarker template
            Map<String, Object> templateData = new HashMap<>();
            templateData.put("name", "Neel Crasta");
            templateData.put("email", to);
            templateData.put("currentYear", String.valueOf(LocalDate.now().getYear()));
            String emailContent = freeMarkerConfig.processTemplate("template-1.ftl", templateData);
            helper.setText(emailContent, true); // Set to true for HTML content


            /*FileSystemResource file
                    = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);*/

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
