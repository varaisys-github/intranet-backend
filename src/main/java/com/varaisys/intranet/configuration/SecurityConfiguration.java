package com.varaisys.intranet.configuration;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.varaisys.intranet.filter.JwtAuthenticationFilter;
import com.varaisys.intranet.serviceImpl.CustomUsersDetailService;

/**
 * @Author Kartik Khurana
 * @CreationDate - 9-11-2022
 * @ModifyDate - 10-11-2022
 * @Desc Class for Security configuration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUsersDetailService customUsersDetailService;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUsersDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/api/token","/api/sendMail","/api/tokenValidation","/api/change-password",
				
			"/api/getAttendanceDetail","/api/addAttendance","/api/getDependents","/api/AddDependents","/api/AddContact","/api/AddEmergencyContact","/api/getPersonContact","/api/Addlanguages","/api/getlanguages","/api/Addskills","/api/getskills","/api/getallExperience","/api/AddExperience","/api/uploadFile","/api/getAllFile","/api/viewImage/{id}","/api/delete/{id}","/api/updateFile","/api/getFile/{id}","/api/saveLeave/{userId}","/api/getAllLeave","/api/getMyLeave/{id}","/api/getLeaveById/{id}","/api/getAllAppliedLeave","/api/finalApproval/{id}","api/reject/{id}","/api/assignleave","/api/myAllLeave/{userId}","/api//getMyLeave/{userId}","/api/entitlement","/api//getMyEnt/{id}","/api/getAllEnt","/api/getMyLeaveBal/{id}","/api//addEntitlement/{id}","/api/getAllEmployeeName")
		.permitAll()
		.antMatchers("/api/ADMIN")
		.hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement()
	    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}