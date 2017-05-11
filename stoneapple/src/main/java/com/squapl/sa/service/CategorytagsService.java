package com.squapl.sa.service;

import java.util.List;

import com.squapl.sa.domain.Categorytags;

public interface CategorytagsService {

	List<Categorytags> findBycategoryName(String categoryName);

	List<Categorytags> findaAll();

	
	
}
