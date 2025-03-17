package com.eight.travel.dto;

import java.util.Date;

public class Review {
    private int id, placeId;
    private String userNickname, reviewText, userEmail;
    private Date createdAt, updatedAt;
	public Review() {
		super();
	}
	
	public Review(int id, int placeId, String userNickname, String reviewText, String userEmail, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.placeId = placeId;
		this.userNickname = userNickname;
		this.reviewText = reviewText;
		this.userEmail = userEmail;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlaceId() {
		return placeId;
	}
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", placeId=" + placeId + ", userNickname=" + userNickname + ", reviewText="
				+ reviewText + ", userEmail=" + userEmail + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
}
