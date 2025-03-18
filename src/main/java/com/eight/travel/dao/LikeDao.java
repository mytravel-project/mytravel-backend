package com.eight.travel.dao;

import org.apache.ibatis.annotations.Mapper;

import com.eight.travel.dto.Like;

@Mapper
public interface LikeDao {
	
	public void recordLike(Like like) throws Exception;
	
	public boolean checkMyPlaceLike(Like like);
	
	public void deleteLike(Like like) throws Exception;
	
	public void toggleLike(Like like) throws Exception;

}
