package com.varaisys.intranet.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varaisys.intranet.dao.TokenValidationDao;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.service.TokenValidationService;


@Service
@Transactional()
public class TokenValidationServiceImpl implements TokenValidationService{

	@Autowired
	TokenValidationDao tokenValidationDao;
	@Override
	public UserInfo findByToken(String token) {
		System.out.println("it is service class");
		
		return tokenValidationDao.matchByToken(token);
	}

}
