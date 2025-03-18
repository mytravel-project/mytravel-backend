package com.eight.travel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.eight.travel.dto.Login;
import com.eight.travel.dto.Review;
import com.eight.travel.service.MemberService;
import com.eight.travel.service.ReviewService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://192.168.0.38:5500"})
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("getRecentReviews")
	public List<Review> getRecentReviews(@RequestBody Review r) {
		try {
			System.out.println(r);
			return reviewService.getRecentReviews(r);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("insertReview")
	public void insertReview(@RequestHeader String authorization, @RequestBody Review r) {
		try {
			Login loginInfo = memberService.checkToken(authorization);
			
			if(loginInfo != null && loginInfo.getLogin_time() != null) {
				long now = System.currentTimeMillis();       
		        long lastRequestTime = loginInfo.getLogin_time().getTime();
		        long interval = now - lastRequestTime;

		        if(interval <= 1800000) {
		        	r.setUserNickname(memberService.getNicknameByEmail(loginInfo.getEmail()));
		        	r.setUserEmail(loginInfo.getEmail());
		        	reviewService.insertReview(r);
		        }
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping("updateReview")
	public void updateReview(@RequestHeader String authorization, @RequestBody Review r) {
		try {
			Login loginInfo = memberService.checkToken(authorization);
			
			if(loginInfo != null && loginInfo.getLogin_time() != null) {
				long now = System.currentTimeMillis();       
		        long lastRequestTime = loginInfo.getLogin_time().getTime();
		        long interval = now - lastRequestTime;
		        
		        
		        if(interval <= 1800000) { 
		        	r.setUserNickname(memberService.getNicknameByEmail(loginInfo.getEmail()));
		        	r.setUserEmail(loginInfo.getEmail());
		        	reviewService.updateReview(r);
		        }
		    }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@PostMapping("deleteReview")
	public void deleteReview(@RequestHeader String authorization, @RequestBody Review r) {
	    try {
	    	Login loginInfo = memberService.checkToken(authorization);
	    	
	    	if(loginInfo != null && loginInfo.getLogin_time() != null) {
	    		long now = System.currentTimeMillis();       
		        long lastRequestTime = loginInfo.getLogin_time().getTime();
		        long interval = now - lastRequestTime;
		        
		        if(interval <= 1800000) {// 30분이 지나지 않았다면
		        	r.setUserEmail(loginInfo.getEmail());
		        	reviewService.deleteReview(r);
		        }
	    	}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
