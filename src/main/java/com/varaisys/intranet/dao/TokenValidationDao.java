package com.varaisys.intranet.dao;

import com.varaisys.intranet.model.UserInfo;


/**
 * 
 * @author Babli singh
 * @created on 13-feb-2023
 * @modify on 13-feb-2023
 */

public interface TokenValidationDao {
	
	public UserInfo matchByToken(String token);

}
