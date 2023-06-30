package com.varaisys.intranet.dao;

import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.utils.EmailDetails;
import java.util.List;



/**
 * 
 * @author Babli singh
 * @created on 7-feb-2023
 * @modify on 10-feb-2023
 */
public interface PasswordResetDao {

	public UserInfo matchByMail(String email);
	
}
