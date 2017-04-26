package com.squapl.sa.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squapl.sa.domain.Advertisement;
import com.squapl.sa.domain.YoutubeElasticsearch;
import com.squapl.sa.elastic.querybuilder.SearchQueryBuilder;



@RestController
@RequestMapping("/elassticsearch")
public class ElasticSearchController {

	@Autowired
	SearchQueryBuilder searchQueryBuilder;
	
	@GetMapping(value="/")
	public List getAll()
	{
		
		return searchQueryBuilder.getAll();
		
	}
}
