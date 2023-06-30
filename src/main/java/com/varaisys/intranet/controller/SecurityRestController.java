package com.varaisys.intranet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varaisys.intranet.serviceImpl.CustomUsersDetailService;
import com.varaisys.intranet.utils.JwtRequest;
import com.varaisys.intranet.utils.JwtUtil;

/**
 * @Author Kartik Khurana
 * @CreationDate - 9-11-2022
 * @ModifyDate - 10-11-2022
 * @Desc Class for Controlling Security API'S
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class SecurityRestController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	CustomUsersDetailService customUsersDetailService;
	@Autowired
	JwtUtil jwtUtil;

	/**
	 * @Author Kartik Khurana
	 * @CreationDate - 9-11-2022
	 * @ModifyDate - 10-11-2022
	 * @Desc Api to generate Token
	 */
	@RequestMapping(value = { "/token" }, method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("username and password=>>>>" + jwtRequest.getUser_name() + jwtRequest.getUser_password());
		try {
			
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUser_name(), jwtRequest.getUser_password()));
			UserDetails userDetails = customUsersDetailService.loadUserByUsername(jwtRequest.getUser_name());
			Object[] role =userDetails.getAuthorities().toArray();
		    
			System.out.println("here is the role value " + role);
			System.out.println(userDetails.getPassword()+"===>"+userDetails.getUsername());
			
			String token = jwtUtil.generateToken(userDetails);
			System.out.println("user token "+ token);
			map.put("status", "successfull");
			map.put("role", role);
			
			map.put("token", token);
		
			return ResponseEntity.ok().body(map);
		} catch (Exception e) {
			System.out.println("error msg "+ e );
			String error ="error";
			
			return ResponseEntity.badRequest().body(error);
		}
		

	}

	@RequestMapping(value = { "/ADMIN" }, method = RequestMethod.GET)
	public String getAdmin() {
		return "Your Role ==> Admin";
	}

}
