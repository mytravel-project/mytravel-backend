package com.eight.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eight.travel.dao.LikeDao;
import com.eight.travel.dto.Like;

@Service
public class LikeService {
	
	@Autowired
	LikeDao likeDao;
	
	public void recordLike(Like like) throws Exception { //좋아요 추가
		likeDao.recordLike(like);
	}
	
	public void deleteLike(Like like) throws Exception { //좋아요 취소
		likeDao.deleteLike(like);
	}
	
	public boolean checkMyPlaceLike(Like like) throws Exception { //좋아요 존재 여부
		return likeDao.checkMyPlaceLike(like);
	}

}
