package com.searchquest.news.service;

import java.util.Date;
import java.util.List;

import com.searchquest.news.model.NewsInfo;
import com.searchquest.news.model.NewsInfoForREST;

public interface NewsService {

	void saveNewsResponseInfo(List<NewsInfoForREST> newsInfoList);
	public List<NewsInfo> getNewsInfoOnTime(Date date) throws Exception;
}
