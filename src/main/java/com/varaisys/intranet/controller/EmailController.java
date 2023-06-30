package com.varaisys.intranet.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.varaisys.intranet.utils.EmailDetails;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.service.EmailService;
import com.varaisys.intranet.service.UserService;
import com.varaisys.intranet.serviceImpl.UserServiceImpl;
import com.varaisys.intranet.utils.JwtRequest;
import com.varaisys.intranet.utils.UserInfoForm;

/**
 * @Author Babli Singh
 * @CreationDate - 7-02-2023
 * @ModifyDate - 7-02-2023
 * @Desc
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class EmailController {

	@Autowired
	private EmailService emailService;
	@Autowired
	private JavaMailSender javaMailSender;
	private String sender = "singhbabli778@gmail.com";

	
	
	
	
	//Abhishek checking code 
	@PostMapping("/sendMail")
	public ResponseEntity<?> sendMail(@RequestBody EmailDetails details,UserInfoForm userInfoForm) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(sender);
		mailMessage.setTo(details.getRecipient());
		mailMessage.setSubject("Change password mail");
		
		
		if (emailService.findByMail(details.getRecipient()) != null) {	
			UserInfo userData=emailService.findByMail(details.getRecipient());
				System.out.println("here is the token value "+ userData.getToken());
				mailMessage.setText("Click here to change your password"+"\n" +"Please find the token " + "' " +userData.getToken() + "'");
			
			javaMailSender.send(mailMessage);
			map.put("Message", "Mail sent successfully");
			return ResponseEntity.ok().body(map);
		}
		map.put("MESSAGE", "Mail does not exist");
		return ResponseEntity.badRequest().body(map);
	}

	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDetails details) {
		String status = emailService.sendMailWithAttachment(details);

		return status;
	}

}
