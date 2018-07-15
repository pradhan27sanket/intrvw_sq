package com.searchquest.news.serviceImpl;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.searchquest.news.model.NewsInfo;
import com.searchquest.news.model.NewsInfoForREST;
import com.searchquest.news.respository.NewsRepository;
import com.searchquest.news.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {


    @Autowired
    NewsRepository newsRepository;
    

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	@Override
	public void saveNewsResponseInfo(List<NewsInfoForREST> newsinfoListForRest) {
		List<NewsInfo> newsinfoList = new ArrayList<NewsInfo>();
		for(NewsInfoForREST n:newsinfoListForRest){
			
			NewsInfo newsInfo = new NewsInfo();
			newsInfo.setContent(n.getContent());
			newsInfo.setContentType(n.getContentType());
			newsInfo.setHeading(n.getHeading());
			newsInfo.setPriority(n.getPriority());
			Date date= null;
			try {
				date = dateFormater.parse(n.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			newsInfo.setTime(date);
			newsinfoList.add(newsInfo);
		}	
		newsRepository.saveAll(newsinfoList);
	}
	
	public List<NewsInfo> getNewsInfoOnTime(Date date) throws Exception{
		
		List<NewsInfo> newsinfo= newsRepository.findRecordsAfterDate(date);
		return newsinfo;
		
	}


}
