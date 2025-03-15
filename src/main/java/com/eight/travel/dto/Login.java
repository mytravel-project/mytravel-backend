package com.eight.travel.dto;

import java.util.Date;

public class Login {
	private String email, token;
	private Date login_time;
	
	public Login() {
		super();
	}
	
	public Login(String email, String token, Date login_time) {
		super();
		this.email = email;
		this.token = token;
		this.login_time = login_time;
	}
	
	@Override
	public String toString() {
		return "Login [ email=" + email + ", token=" + token + ", login_time=" + login_time + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
}
