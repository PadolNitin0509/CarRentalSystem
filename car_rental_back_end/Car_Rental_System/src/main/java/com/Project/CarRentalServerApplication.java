package com.Project;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class,MailSenderAutoConfiguration.class })
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
//@EnableAutoConfiguration(exclude =  MailSenderAutoConfiguration.class)

@SpringBootApplication
public class CarRentalServerApplication {
	
	@Value("${spring.mail.protocol}")
	private String protocol;

	@Value("${spring.mail.username}")
	private String userName;

	@Value("${spring.mail.password}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(CarRentalServerApplication.class, args);
		
		
	}
	
	

}
