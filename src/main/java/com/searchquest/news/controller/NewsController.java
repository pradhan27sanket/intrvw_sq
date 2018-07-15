package com.searchquest.news.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.searchquest.news.model.NewsInfo;
import com.searchquest.news.model.NewsInfoForREST;
import com.searchquest.news.model.NewsInfoHeadingContent;
import com.searchquest.news.model.NewsInfoHeadingPriority;
import com.searchquest.news.service.NewsService;


@RestController
public class NewsController {
	
	public static final String ERROR_MSG = "Error submitting request. Please try later.";
	public static final String SUCCESS_MSG = "Request submitted successfully.";
	
	@Autowired
	NewsService service;

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@RequestMapping(method = RequestMethod.POST, value="/news/details")
	public String saveNewsInfo(@RequestBody List<NewsInfoForREST> newsInfoList){
		service.saveNewsResponseInfo(newsInfoList);
		return  SUCCESS_MSG;
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(method = RequestMethod.GET, value="/news/newsdateheading")
	public List<NewsInfoHeadingPriority> getHeadings(@RequestParam(value = "date", required = false) String date) throws Exception{		
		
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormater.parse(date);
		List<NewsInfo> newsInfoList = service.getNewsInfoOnTime(date1);
		List<NewsInfoHeadingPriority> newsinfoheadingList = new ArrayList<NewsInfoHeadingPriority>();
		newsInfoList.forEach(n->System.out.println("Priority -> " +n.getPriority()));
		for(NewsInfo n:newsInfoList){
			if(n.getPriority()<2){
			NewsInfoHeadingPriority newsinfoheadingp = new NewsInfoHeadingPriority();
			newsinfoheadingp.setHeading(n.getHeading());
			newsinfoheadingp.setPriority(n.getPriority());
			
			newsinfoheadingList.add(newsinfoheadingp);
			}
		}
		return newsinfoheadingList;
		
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(method = RequestMethod.GET, value="/news/newsdatecontent")
	public List<NewsInfoHeadingContent> getcontent(@RequestParam(value = "date", required = false) String date) throws Exception{		
		
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormater.parse(date);
		List<NewsInfo> newsInfoList = service.getNewsInfoOnTime(date1);
		List<NewsInfoHeadingContent> newsinfoheadingcList = new ArrayList<NewsInfoHeadingContent>(); 
		for(NewsInfo n:newsInfoList){
			NewsInfoHeadingContent newsinfoheadingp = new NewsInfoHeadingContent();
			newsinfoheadingp.setHeading(n.getHeading());
			newsinfoheadingp.setContent(n.getContent());

			newsinfoheadingcList.add(newsinfoheadingp);
		}			
		return newsinfoheadingcList;		
	}
}
