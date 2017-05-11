package com.squapl.sa.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squapl.sa.domain.Categorytags;
import com.squapl.sa.service.CategorytagsService;

@RestController
@RequestMapping("/category")
public class Category_tagsController {

	
	@Autowired
	CategorytagsService category_tagsService;
	
	@GetMapping(value="/{value}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Categorytags>> findall(@PathVariable("value") String categoryName){
		
		
		Iterable<Categorytags> tags = category_tagsService.findBycategoryName(categoryName);
		
		return new ResponseEntity<Iterable<Categorytags>>(tags,HttpStatus.OK);
		
		
	}
	
	
	@GetMapping(value="/list",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Categorytags>> findall(){
		
		
		Iterable<Categorytags> tags = category_tagsService.findaAll();
		
		return new ResponseEntity<Iterable<Categorytags>>(tags,HttpStatus.OK);
		
		
	}
	
}
