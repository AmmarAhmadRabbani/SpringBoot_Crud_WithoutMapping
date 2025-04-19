package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmailDto;
import com.example.demo.dto.EmailMultipleDto;
import com.example.demo.exception.EmailIdNotFoundException;

@Service
public class EmialServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private MailProperties mailProperties;

	@Override
	public EmailDto sendEmailSingleUser(EmailDto emailDto) {
		if (emailDto != null) {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(mailProperties.getUsername());
//			simpleMailMessage.setFrom("ammarthegenious@gmail.com");
			simpleMailMessage.setTo(emailDto.getEmailId());
//			simpleMailMessage.setSubject("Greetings of the Day!");
			simpleMailMessage.setSubject(emailDto.getSubject());
			simpleMailMessage.setText(emailDto.getBody());
			javaMailSender.send(simpleMailMessage);
			return emailDto;
		}
		throw new EmailIdNotFoundException("Invalid Email Id");

	}

	@Override
	public EmailMultipleDto sendEmailMultipleUsers(EmailMultipleDto emailMultipleDto) {
		if (emailMultipleDto != null) {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("ammarthegenious@gmail.com");
			simpleMailMessage.setTo(emailMultipleDto.getEmailID());
			simpleMailMessage.setSubject(emailMultipleDto.getSubject());
			simpleMailMessage.setText(emailMultipleDto.getBody());
			javaMailSender.send(simpleMailMessage);
			return emailMultipleDto;

		}

		throw new EmailIdNotFoundException("Email Id Not Found");
	}

}
