package com.varaisys.intranet.utils;

/**
 * @Author Kartik Khurana
 * @CreationDate - 09-11-2022
 * @ModifyDate - 09-11-2022
 * @Desc Jwt Request model
 */
public class JwtRequest {

	private String user_name;
	private String user_password;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

}
