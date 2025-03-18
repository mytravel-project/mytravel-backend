package com.eight.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eight.travel.dao.ReviewDao;
import com.eight.travel.dto.Review;

@Service
public class ReviewService {
	@Autowired
	ReviewDao reviewDao;

	public List<Review> getRecentReviews(Review r) throws Exception{
		return reviewDao.getRecentReviews(r);
	}

    public void insertReview(Review r) throws Exception {
        reviewDao.insertReview(r);
    }
    
    public void updateReview(Review r) throws Exception {
        reviewDao.updateReview(r);
    }
    
    public void deleteReview(Review r) throws Exception {
        reviewDao.deleteReview(r);
    }
}
