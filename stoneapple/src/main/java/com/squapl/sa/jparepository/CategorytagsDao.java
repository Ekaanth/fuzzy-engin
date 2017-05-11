package com.squapl.sa.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.squapl.sa.domain.Categorytags;


@Repository
public interface CategorytagsDao extends JpaRepository<Categorytags, Long> {

//	
//	@Query("SELECT tags FROM category_tags tags WHERE tags.category_name = (:categoryName)")
//	 List<Category_tags> findByCategory_name(@Param("categoryName") String categoryName);

//	List<Category_tags> findByCategory_name(String categoryName);
	
	List<Categorytags> findBycategoryname(String category_name);
}
