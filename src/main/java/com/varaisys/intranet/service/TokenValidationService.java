package com.varaisys.intranet.service;

import com.varaisys.intranet.model.UserInfo;


/**
 * @Author Babli Singh
 * @CreationDate - 13-02-2023
 * @ModifyDate - 13-02-2023
 * @Desc
 */
public interface TokenValidationService {
	
	UserInfo findByToken(String token);

}
