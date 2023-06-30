package com.varaisys.intranet.serviceImpl;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.varaisys.intranet.dao.PasswordResetDao;
import com.varaisys.intranet.utils.EmailDetails;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.service.EmailService;

import lombok.Value;

/**
 * @Author Babli Singh
 * @CreationDate - 7-02-2023
 * @ModifyDate - 7-02-2023
 * @Desc
 */
@Service
@Transactional()
public class EmailServiceImpl implements EmailService {

	@Autowired
	
	private JavaMailSender javaMailSender;

	@Autowired
	PasswordResetDao passWordResetDao;

	private String sender = "singhbabli778@gmail.com";

	@Override
	public String sendSimpleMail(EmailDetails details) {
		return "Mail Sent Successfully...";
	}

	@Override
	public String sendMailWithAttachment(EmailDetails details) {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {
			

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText("This is test");
			mimeMessageHelper.setSubject("testing mail");

			FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

			mimeMessageHelper.addAttachment(file.getFilename(), file);

			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		catch (MessagingException e) {

			return "Error while sending mail!!!";
		}
	}

	@Override
	public UserInfo findByMail(String mail) {
		return passWordResetDao.matchByMail(mail);
		
		
		
	}


	

	

}
