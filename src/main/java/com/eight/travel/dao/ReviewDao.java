package com.eight.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eight.travel.dto.Review;

@Mapper
public interface ReviewDao {	
	
	public List<Review> getRecentReviews(Review r) throws Exception;
	
	public void insertReview(Review r) throws Exception;
	
	public void updateReview(Review r) throws Exception;
	
	public void deleteReview(String email) throws Exception; 
}
