package com.eight.travel.dto;

import java.util.Date;

public class Like {
	
	private String userEmail;
	private int placeId;
	private Date created_at;
	
	public Like() {
		super();
	}

	public Like(String userEmail, int placeId, Date created_at) {
		super();
		setUserEmail(userEmail);
		setPlaceId(placeId);
		setCreated_at(created_at);
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Like [userEmail=" + userEmail + ", placeId=" + placeId + ", created_at=" + created_at + "]";
	}

}
