package com.varaisys.intranet.utils;

public class TokenData {

	private String token;
	private String password;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TokenData(String token, String password) {
		super();
		this.token = token;
		this.password = password;
	}

	public TokenData() {
		super();
	}

}
