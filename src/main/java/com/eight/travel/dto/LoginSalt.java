package com.eight.travel.dto;

public class LoginSalt {
	private String email, salt, created_at;
	
	public LoginSalt() {
		super();
	}

	public LoginSalt(String email, String salt, String created_at) {
		super();
		this.email = email;
		this.salt = salt;
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "LoginSalt [email=" + email + ", salt=" + salt + ", created_at=" + created_at + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
}
