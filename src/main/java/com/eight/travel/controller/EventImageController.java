package com.eight.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eight.travel.dto.EventImage;
import com.eight.travel.service.EventImageService;

@RestController
@CrossOrigin("http://192.168.0.38:5500")
public class EventImageController {
	
	@Autowired
	EventImageService eventImageService;
	
	@GetMapping("getAllEventImages")
	public List<EventImage> getAllEventImages() {
		try {
			return eventImageService.getAllEventImages();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
