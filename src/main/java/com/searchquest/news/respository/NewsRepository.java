package com.searchquest.news.respository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.searchquest.news.model.NewsInfo;

public interface NewsRepository extends CrudRepository<NewsInfo, Long> {
	
	@Query(value = "SELECT * FROM test.newsInfo WHERE newstime >= :date",nativeQuery=true)
    public List<NewsInfo> findRecordsAfterDate(@Param("date") Date date);

}