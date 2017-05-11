package com.squapl.sa.service;

import java.security.Principal;
import java.util.List;

import com.squapl.sa.domain.Category;

public interface Categoryservice {


	 List<Category> findCategoryList(Principal principal);
}
