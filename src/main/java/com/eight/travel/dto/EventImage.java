package com.eight.travel.dto;

public class EventImage {
	
	private int eventcode;
	private String category, eventname, eventimg;
	
	public EventImage() {
		super();
	}

	public EventImage(int eventcode, String category, String eventname, String eventimg) {
		super();
		setEventcode(eventcode);
		setCategory(category);
		setEventname(eventname);
		setEventimg(eventimg);
	}

	public int getEventcode() {
		return eventcode;
	}

	public void setEventcode(int eventcode) {
		this.eventcode = eventcode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventimg() {
		return eventimg;
	}

	public void setEventimg(String eventimg) {
		this.eventimg = eventimg;
	}

	@Override
	public String toString() {
		return "EventImage [eventcode=" + eventcode + ", category=" + category + ", eventname=" + eventname
				+ ", eventimg=" + eventimg + "]";
	}
}