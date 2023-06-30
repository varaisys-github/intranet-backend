package com.varaisys.intranet.service;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;

import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.utils.EmailDetails;

/**
 * @Author Babli Singh
 * @CreationDate - 7-02-2023
 * @ModifyDate - 7-02-2023
 * @Desc
 */
public interface EmailService {
	 String sendSimpleMail(EmailDetails details);
	 String sendMailWithAttachment(EmailDetails details);
	 UserInfo findByMail(String details);
//	List<EmailDetails> existsByEmail(String userEmail);
//	
//	public void sendEmail(SimpleMailMessage email);
	


}
