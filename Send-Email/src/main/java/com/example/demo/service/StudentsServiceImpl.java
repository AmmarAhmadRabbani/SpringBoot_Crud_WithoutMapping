package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentsDto;
import com.example.demo.entity.Customers;
import com.example.demo.entity.Students;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.repository.StudentsRepository;
import com.example.demo.utils.StudentsUtils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private StudentsRepository studentsRepository;

	@Override
	public String registerwithCredentilasWithFileAttachedofStudents(StudentsDto studentsDto) throws IOException {
		if (studentsDto != null) {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			try {
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

				mimeMessageHelper.setFrom("ammarthegenious@gmail.com");
				mimeMessageHelper.setTo(studentsDto.getEmailId());
				mimeMessageHelper.setSubject("You are Welcome");
				mimeMessageHelper.setText("Dear Customer :" + studentsDto.getCustomerName() + "," + "\n"
						+ "Please find your Credentias" + "\n" + " EmailId:" + studentsDto.getEmailId() + "\n"
						+ "Password:" + studentsDto.getPassword() + "\n" + "Please Login with your Credentials." + ""
						+ "\n" + "Thanks & Regards" + "," + "\n " + "Teams");
				mimeMessageHelper.addAttachment(studentsDto.getAttachment().getOriginalFilename(),
						StudentsUtils.convertMultipartToFile(studentsDto.getAttachment(),
								studentsDto.getAttachment().getOriginalFilename()));
				javaMailSender.send(mimeMessage);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			Customers customers = new Customers();
			Students students = new Students();
			BeanUtils.copyProperties(studentsDto, students);
			studentsRepository.save(students);
			BeanUtils.copyProperties(students, studentsDto);
			return "Got Email Successfully";
		}
		throw new CustomerNotFoundException("Customer Details Unavailable");
	}

	/*
	 * private static File convertMultipartToFile(MultipartFile multipartFile,
	 * String fileName) throws IOException { File convFile = new
	 * File(System.getProperty("java.io.tmpdir") + "/" + fileName);
	 * multipartFile.transferTo(convFile); return convFile; }
	 * 
	 */

}
