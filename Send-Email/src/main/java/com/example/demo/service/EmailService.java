package com.example.demo.service;

import com.example.demo.dto.EmailDto;
import com.example.demo.dto.EmailMultipleDto;

public interface EmailService {
	public EmailDto sendEmailSingleUser(EmailDto emailDto);

	public EmailMultipleDto sendEmailMultipleUsers(EmailMultipleDto emailMultipleDto);

}
 