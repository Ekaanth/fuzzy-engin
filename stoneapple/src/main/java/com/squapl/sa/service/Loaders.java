package com.squapl.sa.service;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.squapl.sa.domain.Facebook;
import com.squapl.sa.domain.Item;
import com.squapl.sa.domain.MyPojo;
import com.squapl.sa.domain.Statistics;
import com.squapl.sa.domain.YoutubeElasticsearch;
import com.squapl.sa.domain.facebook.Data;
import com.squapl.sa.domain.facebook.FacebookFeeds;
import com.squapl.sa.domain.facebook.Feed;
import com.squapl.sa.domain.youtube.Default;
import com.squapl.sa.domain.youtube.Id;
import com.squapl.sa.domain.youtube.Items;
import com.squapl.sa.domain.youtube.MainYoutube;
import com.squapl.sa.domain.youtube.Snippet;
import com.squapl.sa.domain.youtube.Thumbnails;
import com.squapl.sa.elasticrepository.ElasticRepository;
import com.squapl.sa.elasticrepository.FacebookElasticRepository;

@Service
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;
    
    @Autowired
   ElasticRepository elasticeRepository;
    
    @Autowired
    FacebookElasticRepository facebook;
//    @Autowired 
//    com.squapl.sa.domain.UsersRepository domainUsersRegistory;
//    com.squapl.sa.domain.Users domainUsers;

    @PostConstruct
    @Transactional
    @Scheduled(cron="59 59 * * * ?")//(sec min hr dayofmonth month dayofweek year)
    public void loadAll(){

    	
    	String search=null;
    	
        operations.putMapping(YoutubeElasticsearch.class);
       elasticeRepository.deleteAll();
        System.out.println("Youtube Loading Data");
        
        Calendar cal = Calendar.getInstance();
        int currentHour = cal.get(Calendar.HOUR);
        
        if (currentHour > 5 && currentHour < 7){
        	search="spritual";
        }
        else if(currentHour >= 7 && currentHour < 10){
        	search="breakfast";
        }
        else if(currentHour >= 10 && currentHour < 14){
        	search="food";
        }
        else if(currentHour >= 14 && currentHour < 16){
        	search="dinner";
        }
        
        elasticeRepository.save(getData(search));
        System.out.printf("Youtube Loading Completed");
        
        
        operations.putMapping(Facebook.class);
        facebook.deleteAll();
        System.out.println("loading facebook");
        facebook.save(facebookAll());
        System.out.println("loading facebook done");
        
    }




	private List<Facebook> facebookAll() {
	

		List<Facebook> feeds = new ArrayList<>();
		
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 URL url = null;
		try {
			url = new URL("https://graph.facebook.com/v2.9/squaplmagazine?fields=feed.limit(25)&access_token=877133062459892%7Cx7-ySGYaS7V28HYEeCHozRbkKFc");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.println(url);   
		 InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacebookFeeds facebookjson = new Gson().fromJson(reader, FacebookFeeds.class);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");
		Feed f = facebookjson.getFeed();
		System.out.println(f);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		Data[] data = f.getData();
		System.out.println(data);
		System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIII");
		for(Data d : data){
			System.out.println(d.getId());
			System.out.println(d.getMessage());
			feeds.add(new Facebook(d.getId(), d.getMessage(), d.getCreated_time()));
		}
		
	return feeds;
}

	private List<YoutubeElasticsearch> getData(String search) {
    	
    	 List<YoutubeElasticsearch> videolist = new ArrayList<>();
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		 URL url = null;
		try {
			url = new URL("https://www.googleapis.com/youtube/v3/search?part=snippet&fields=items(id,snippet)&q="+search+"&regionCode=In&maxResults=25&key=AIzaSyDHsEchtvchZpilJNf_jizUnxNjM15KFYg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.println(url);   
		 InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainYoutube mainjson = new Gson().fromJson(reader, MainYoutube.class);
	      System.out.println("11111111111111111111111111111");
    	Items[] item = mainjson.getItems();
    	System.out.println("222222222222222222222222222222222222");
    	for(Items it :item){
    		//System.out.println("33333333333333333333");
    		Id id = it.getId();
    		//System.out.println(id.getVideoId()); // video id
    		Snippet snip = it.getSnippet();
    		//System.out.println(snip.getPublishedAt()); //publish date
    		snip.getChannelId();
    		snip.getTitle();
    		snip.getDescription();
    		snip.getChannelTitle();
    		//Thumbnails thumb = snip.getThumbnails();
    		//Default def = thumb.getDefault();
    		//def.getUrl();
    		//System.out.println(def.getUrl());
    		
    		 URL url1 = null;
 			try {
 				url1 = new URL("https://www.googleapis.com/youtube/v3/videos?part=statistics&fields=items(statistics)&id="+id.getVideoId()+"&key=AIzaSyDHsEchtvchZpilJNf_jizUnxNjM15KFYg");
 			} catch (MalformedURLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 		     System.out.println(url1);   
 			 InputStreamReader reader1 = null;
 			try {
 				reader1 = new InputStreamReader(url1.openStream());
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			MyPojo item1 = new Gson().fromJson(reader1, MyPojo.class);
 		      //  System.out.println("444444444444444444444444444444");
 		  String view = null;
 		  String like = null;
 		  String dislike = null;
 		  String comment = null;
 		  String favorite = null;
 		       Item[] its = item1.getItems();
 		       for(Item itm: its){
 		    	   Statistics stat = itm.getStatistics();
 		    	//  System.out.println(item1);
 		    	 like =  stat.getLikeCount();
 	 		    dislike=  stat.getDislikeCount();
 	 		  comment=  stat.getCommentCount();
 	 		    view = stat.getViewCount();
 	 		  favorite=  stat.getFavoriteCount();
 		       }
    		
 		      if( view != null){
 		    	 videolist.add(new YoutubeElasticsearch(id.getVideoId(), snip.getPublishedAt(), snip.getPublishedAt(), snip.getTitle(), snip.getDescription(), "kjbjk", snip.getChannelTitle(),like , dislike, comment, view, favorite));
 		      }
    	}
    	System.out.println(videolist);
		return videolist;
    }
}

    	
       
       
        
      