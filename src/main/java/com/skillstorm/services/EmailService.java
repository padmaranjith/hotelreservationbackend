package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	public EmailService(JavaMailSender emailSender) {
		this.emailSender=emailSender;
	}
	
	public void sendEmail(String to, String subject, String body) {
       
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("inboxgrandvista@gmail.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        emailSender.send(mailMessage);
        
        System.out.println("Mail Sent Successfully");
    }
	
}
