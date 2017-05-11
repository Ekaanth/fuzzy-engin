package com.squapl.sa.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.squapl.sa.domain.Tags;
import com.squapl.sa.jparepository.TagsDao;

public class TagsServiceImp {

	
	@Autowired
	TagsDao tagsdao;
	
	public List<Tags> findAll(){
		
		return tagsdao.findAll();
	}
}
