package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendContactEmail(String from, String name, String messageText) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("rushimali038@gmail.com");
		message.setSubject("New contact Message From :" + name);
		message.setText("Sender:" + from + "\n\nMessage:\n" + messageText);
		mailSender.send(message);

	}
}
