package com.squapl.sa.service.UserServiceImpl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Category;
import com.squapl.sa.jparepository.CategoryDao;
import com.squapl.sa.service.Categoryservice;

@Service
public class CategoryServiceImp implements Categoryservice {

	@Autowired
	CategoryDao categoryDao;

	
	public List<Category> findCategoryList(Principal principal) {
		
		return (List<Category>) categoryDao.findAll();
	}


	public List<Category> findAll() {
		return (List<Category>) categoryDao.findAll();
		
	}

	
}
