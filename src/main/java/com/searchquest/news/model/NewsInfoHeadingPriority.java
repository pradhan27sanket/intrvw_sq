package com.searchquest.news.model;

public class NewsInfoHeadingPriority {
	
	public int getPriority() {
		return Priority;
	}
	public void setPriority(int priority) {
		Priority = priority;
	}
	public String getHeading() {
		return Heading;
	}
	public void setHeading(String heading) {
		Heading = heading;
	}
	private int Priority;
	private String Heading;

}
