package com.searchquest.news.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.searchquest.news.controller.NewsController;
import com.searchquest.news.model.NewsInfo;
import com.searchquest.news.model.NewsInfoForREST;
import com.searchquest.news.model.NewsInfoHeadingContent;
import com.searchquest.news.model.NewsInfoHeadingPriority;
import com.searchquest.news.respository.NewsRepository;
import com.searchquest.news.service.NewsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsTestApplication {

	@Test
	public void dummyTest() {
	}
	
	@Mock
	NewsRepository newsRepositoryMock;
	@Mock 
	NewsService newsServiceMock;
	@Mock
	NewsController newscontrollerMock;
	@InjectMocks
	NewsController newscontrollerInjectMock = new NewsController();
	
	@Test
	public void testSaveNewsInfo()
	{	
		
		NewsService newsServiceMock = Mockito.mock(NewsService.class);
		NewsInfoForREST newsInfoREST = new NewsInfoForREST();
		newsInfoREST.setContent("Sports");
		newsInfoREST.setPriority(1);
		newsInfoREST.setContentType("content of sports1 news");
		newsInfoREST.setHeading("sports1 news");
		newsInfoREST.setTime("2018-07-15 1:04:04:123");
		List<NewsInfoForREST> newsInfoRESTList = new ArrayList<NewsInfoForREST>();
		newsInfoRESTList.add(newsInfoREST);
		Mockito.doNothing().when(newsServiceMock).saveNewsResponseInfo(Mockito.anyList());
		//Mockito.doNothing().when(newsRepositoryMock).saveAll(Mockito.anyCollectionOf(NewsInfo.class));
		Mockito.when(newsRepositoryMock.saveAll(Mockito.anyCollectionOf(NewsInfo.class)))
		.thenReturn(Mockito.anyCollectionOf(NewsInfo.class));
		String actual = newscontrollerInjectMock.saveNewsInfo(newsInfoRESTList);
		String expected = "Request submitted successfully.";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testgetHeadings() throws Exception{
		String date = "2018-07-15 1:04:04:123";
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormater.parse(date);
		NewsInfo newsInfoREST = new NewsInfo();
		newsInfoREST.setContent("Sports");
		newsInfoREST.setPriority(1);
		newsInfoREST.setContentType("content of sports1 news");
		newsInfoREST.setHeading("sports1 news");
		newsInfoREST.setTime(date1);
		List<NewsInfo> newsInfoList = new ArrayList<NewsInfo>();
		newsInfoList.add(newsInfoREST);
		Mockito.when(newsServiceMock.getNewsInfoOnTime(Mockito.any(Date.class))).thenReturn(newsInfoList);
		List<NewsInfoHeadingPriority> newsinfoheadingList = newscontrollerInjectMock.getHeadings(date);
		String actual=null;
		for(NewsInfoHeadingPriority n:newsinfoheadingList){
			actual=n.getHeading();
		}
		
		Assert.assertEquals("sports1 news",actual);
	}
	
	@Test
	public void getcontenttest() throws Exception{
		String date = "2018-07-15 1:04:04:123";
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormater.parse(date);
		NewsInfo newsInfoREST = new NewsInfo();
		newsInfoREST.setContent("Sports");
		newsInfoREST.setPriority(1);
		newsInfoREST.setContentType("content of sports1 news");
		newsInfoREST.setHeading("sports1 news");
		newsInfoREST.setTime(date1);
		List<NewsInfo> newsInfoList = new ArrayList<NewsInfo>();
		newsInfoList.add(newsInfoREST);
		Mockito.when(newsServiceMock.getNewsInfoOnTime(Mockito.any(Date.class))).thenReturn(newsInfoList);
		List<NewsInfoHeadingContent> newsinfoheadingList = newscontrollerInjectMock.getcontent(date);
		String actual=null;
		for(NewsInfoHeadingContent n:newsinfoheadingList){
			actual=n.getHeading();
		}
		
		Assert.assertEquals("sports1 news",actual);
	}

}

