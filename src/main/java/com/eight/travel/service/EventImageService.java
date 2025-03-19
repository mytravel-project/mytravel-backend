package com.eight.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eight.travel.dao.EventImageDao;
import com.eight.travel.dto.EventImage;

@Service
public class EventImageService {
	
	@Autowired
	EventImageDao eventImageDao;
	
	public List<EventImage> getAllEventImages() {
		return eventImageDao.getAllEventImages();
	}

}
