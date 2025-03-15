package com.eight.travel.dto;

import java.util.Date;

public class Member {
	private String nickname, email, password, residence_state, residence_city, gender;
	private int birth_year;
	
	
    private int failedAttempts; // 로그인 실패 횟수 추가
    private boolean accountNonLocked = true; // 계정 잠금 여부
    private Date lockTime; // 계정 잠금 시간 (null이면 잠기지 않은 상태)
	
	public Member() {
		super();
	}
	
	public Member(String nickname, String email, String password, String residence_state, String residence_city, int birth_year, String gender) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.residence_state = residence_state;
		this.residence_city = residence_city;
		this.birth_year = birth_year;
		this.gender = gender;
        this.accountNonLocked = true; // 기본적으로 계정은 잠기지 않음
        this.failedAttempts = 0;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "Member [nickname=" + nickname + ", email=" + email + ", password=" + password + ", residence_state="
				+ residence_state + ", residence_city=" + residence_city + ", gender=" + gender + ", birth_year="
				+ birth_year + ", failedAttempts=" + failedAttempts + ", accountNonLocked=" + accountNonLocked
				+ ", lockTime=" + lockTime + "]";
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	public int getBirth_year() {
		return birth_year;
	}
	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}
	
    public int getFailedAttempts() { 
    	return failedAttempts; 
    }
    public void setFailedAttempts(int failedAttempts) { 
    	this.failedAttempts = failedAttempts; 
    }
    public boolean isAccountNonLocked() { 
    	return accountNonLocked; 
    }
    public void setAccountNonLocked(boolean accountNonLocked) { 
    	this.accountNonLocked = accountNonLocked; 
    }
    public Date getLockTime() { 
    	return lockTime; 
    }
    public void setLockTime(Date lockTime) { 
    	this.lockTime = lockTime; 
    }
	
}
