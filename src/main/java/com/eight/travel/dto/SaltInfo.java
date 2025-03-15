package com.eight.travel.dto;

import java.util.Date;

public class SaltInfo {
	
	private String email, salt;
	private Date created_at;
	
	public SaltInfo() {
		super();
	}

	public SaltInfo(String email, String salt, Date created_at) {
		super();
		setEmail(email);
		setSalt(salt);
		setCreated_at(created_at);
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "SaltInfo [email=" + email + ", salt=" + salt + ", created_at=" + created_at + "]";
	}

}
