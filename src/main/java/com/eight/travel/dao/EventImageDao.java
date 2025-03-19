package com.eight.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eight.travel.dto.EventImage;

@Mapper
public interface EventImageDao {
	
	List<EventImage> getAllEventImages();

}
