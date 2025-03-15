package com.eight.travel.dto;

import java.util.Date;

public class Member {
	
	private int birth_year;
	private String nickname, email, password, residence_state, residence_city, gender;
	private Date created_at;
	
	public Member() {
		super();
	}

	public Member(int birth_year, String nickname, String email, String password, String residence_state,
			String residence_city, String gender, Date created_at) {
		super();
		setBirth_year(birth_year);
		setNickname(nickname);
		setEmail(email);
		setPassword(password);
		setResidence_state(residence_state);
		setResidence_city(residence_city);
		setGender(gender);
		setCreated_at(created_at);
	}

	public int getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResidence_state() {
		return residence_state;
	}

	public void setResidence_state(String residence_state) {
		this.residence_state = residence_state;
	}

	public String getResidence_city() {
		return residence_city;
	}

	public void setResidence_city(String residence_city) {
		this.residence_city = residence_city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Member [birth_year=" + birth_year + ", nickname=" + nickname + ", email=" + email + ", password="
				+ password + ", residence_state=" + residence_state + ", residence_city=" + residence_city + ", gender="
				+ gender + ", created_at=" + created_at + "]";
	}

}
