package com.squapl.sa.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Categorytags;
import com.squapl.sa.jparepository.CategorytagsDao;
import com.squapl.sa.service.CategorytagsService;


@Service
public class Category_tagsServiceImp implements CategorytagsService{

	@Autowired
	CategorytagsDao categorytagsDao;
	
	
	@Override
	public List<Categorytags> findaAll() {
		
		return (List<Categorytags>) categorytagsDao.findAll();
	}


	@Override
	public List<Categorytags> findBycategoryName(String categoryName) {
		
		return (List<Categorytags>) categorytagsDao.findBycategoryname(categoryName);
	}

}
