package com.searchquest.news.model;

public class NewsInfoForREST{
		
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
		public String getTime() {
			return NewsTime;
		}
		public void setTime(String time) {
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
		private String NewsTime;
		private String Heading;
		private String Content;

	
}
