package com.squapl.sa.jparepository;

import org.springframework.data.repository.CrudRepository;

import com.squapl.sa.domain.Category;

public interface CategoryDao extends CrudRepository<Category, Long>{

}
