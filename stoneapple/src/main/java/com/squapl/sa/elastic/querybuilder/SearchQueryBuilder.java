package com.squapl.sa.elastic.querybuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import com.squapl.sa.domain.Advertisement;
import com.squapl.sa.domain.Facebook;
import com.squapl.sa.domain.YoutubeElasticsearch;
import com.squapl.sa.elasticrepository.ElasticRepository;


@Component
public class SearchQueryBuilder {

	
	@Autowired
	ElasticRepository elastic;
	
	 @Autowired
	    private ElasticsearchTemplate elasticsearchTemplate;
	 
	 public List getAll(){
		 
		List l = new ArrayList<>();
		List all = new ArrayList<>();
	// QueryBuilder query = (QueryBuilders.matchAllQuery()).;
//		 
//		 System.out.println(query);
//		 
//		 NativeSearchQuery build = new NativeSearchQueryBuilder()
//	                .withQuery(query)
//	                .build();
		 
		// System.out.println(build);
		
		int aPageRequestcount = 20;       //get all and count it 

		NativeSearchQueryBuilder QueryBuilderYoutube = new NativeSearchQueryBuilder();  
		NativeSearchQueryBuilder QueryBuilderFacebook = new NativeSearchQueryBuilder();  
		
		QueryBuilderFacebook.withIndices("facebook").withTypes("facebook").withPageable(new PageRequest(0, aPageRequestcount));
		QueryBuilderYoutube.withIndices("youtube").withTypes("youtube").withPageable(new PageRequest(0, aPageRequestcount));
		
		final BoolQueryBuilder aQuery = new BoolQueryBuilder();
		
		NativeSearchQuery nativeSearchQueryYoutube = QueryBuilderYoutube.withQuery(aQuery).build();
		NativeSearchQuery nativeSearchQueryFacebook = QueryBuilderFacebook.withQuery(aQuery).build();
		
		List<YoutubeElasticsearch> youtube =   elasticsearchTemplate.queryForList(nativeSearchQueryYoutube, YoutubeElasticsearch.class);
		List<Facebook> facebook =   elasticsearchTemplate.queryForList(nativeSearchQueryFacebook, Facebook.class);
		
	
		 l.addAll(facebook);
		 l.addAll(youtube);
		 
		 Iterator it = l.iterator();
		 int i=1;
		 while(it.hasNext()){
			 i++;
			 if(i%5==0){
				 all.add(new Advertisement("one", "add", "hello everyone"));
			 }
			 else{
			 all.add(it.next());
			 }
		 }
		 
		 
		return all;
		 
	 }
	 
}
