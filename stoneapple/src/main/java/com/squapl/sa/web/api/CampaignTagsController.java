package com.squapl.sa.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squapl.sa.domain.CampaignTags;
import com.squapl.sa.domain.Category;
import com.squapl.sa.jparepository.CampaignTagsDao;
import com.squapl.sa.service.UserServiceImpl.CampaignTagService;
import com.squapl.sa.service.UserServiceImpl.CategoryServiceImp;

@RestController
@RequestMapping("/category")
public class CampaignTagsController {

	@Autowired
	CampaignTagService campaignTagService; 
	
	@Autowired
	CategoryServiceImp categoryServiceImp;
	
	@GetMapping(value="/all",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<CampaignTags>> findall(){
		
		
		Iterable<CampaignTags> tags = campaignTagService.findall();
		
		return new ResponseEntity<Iterable<CampaignTags>>(tags,HttpStatus.OK);
		
		
	}
	
	
}
