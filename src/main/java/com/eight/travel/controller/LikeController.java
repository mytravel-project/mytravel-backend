package com.eight.travel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.eight.travel.dto.Like;
import com.eight.travel.dto.Login;
import com.eight.travel.service.LikeService;
import com.eight.travel.service.MemberService;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://192.168.144.1/5500"})
public class LikeController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	LikeService likeService;
	
	@PostMapping("checkMyPlaceLike")
	public Map<String, Boolean> checkMyPlaceLike(@RequestHeader String authorization, @RequestBody Like like) {
	    Map<String, Boolean> response = new HashMap<>();

	    try {

	        Login loginInfo = memberService.checkToken(authorization);
	        if (loginInfo == null) {
	            response.put("isLiked", false);
	            return response;
	        }

	        like.setUserEmail(loginInfo.getEmail());
	        
	        //장소 체크
	        if (like.getPlaceId() == 0 || like.getPlaceId() <= 0 ) {
	            response.put("isLiked", false);
	            return response;
	        }

	        boolean isLiked = likeService.checkMyPlaceLike(like);
	        response.put("isLiked", isLiked);

	        return response;

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("isLiked", false);
	        return response;
	    }
	}
	
	@PostMapping("toggleLike")
	public Map<String, String> toggleLike(@RequestHeader String authorization, @RequestBody Like like) {
	    System.out.println(authorization);
	    System.out.println(like);

	    Map<String, String> response = new HashMap<>();

	    try {
	        Login loginInfo = memberService.checkToken(authorization);

	        if (loginInfo == null) {
	            response.put("message", "유효하지 않은 토큰입니다.");
	            return response;
	        }

	        long now = System.currentTimeMillis(); 
	        long lastRequestTime = (loginInfo.getLogin_time() != null) ? loginInfo.getLogin_time().getTime() : 0;
	        long interval = now - lastRequestTime; 
	        System.out.println("interval: " + interval);

	        if (interval > 1800000) {
	            response.put("message", "로그인이 만료되었습니다. 다시 로그인하세요.");
	            return response;
	        }

	        like.setUserEmail(loginInfo.getEmail());  
	        boolean isLiked = likeService.checkMyPlaceLike(like);

	        if (isLiked) {
	            likeService.deleteLike(like);
	            response.put("message", "좋아요가 취소되었습니다.");
	        } else {
	            likeService.recordLike(like);
	            response.put("message", "좋아요를 눌렀습니다.");
	        }

	        return response;

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("message", "서버 오류 발생: " + e.getMessage());
	        return response;
	    }
	}

}
