package com.eight.travel.dto;

import java.util.Date;

public class Login {
	private String email, token, nickname;
	private Date login_time;
	
	public Login() {
		super();
	}
	
	public Login(String email, String token, String nickname, Date login_time) {
		this.email = email;
		this.token = token;
		this.login_time = login_time;
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Login [email=" + email + ", token=" + token + ", nickname=" + nickname + ", login_time=" + login_time
				+ "]";
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
