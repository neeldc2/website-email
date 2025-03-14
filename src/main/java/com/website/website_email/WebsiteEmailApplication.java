package com.website.website_email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class WebsiteEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteEmailApplication.class, args);
	}

}
