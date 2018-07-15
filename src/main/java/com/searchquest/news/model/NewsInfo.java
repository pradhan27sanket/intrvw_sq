package com.searchquest.news.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newsInfo")
public class NewsInfo implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String ContentType;
	public String getContentType() {
		return ContentType;
	}
	public void setContentType(String contentType) {
		ContentType = contentType;
	}
	public int getPriority() {
		return Priority;
	}
	public void setPriority(int priority) {
		Priority = priority;
	}
	public Date getTime() {
		return NewsTime;
	}
	public void setTime(Date time) {
		NewsTime = time;
	}
	public String getHeading() {
		return Heading;
	}
	public void setHeading(String heading) {
		Heading = heading;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	private int Priority;
	private Date NewsTime;
	private String Heading;
	private String Content;
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
