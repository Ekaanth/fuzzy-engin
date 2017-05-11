package com.squapl.sa.jparepository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.squapl.sa.domain.Article;

@Repository
public interface ArticleDAO extends JpaRepository<Article, Long> {

    List<Article> findAll();
    
    List<Article> findByLanguage(String language);
    
    List<Article> findByStatus(String status);
//
//    @Modifying
//    @Query("SELECT a FROM Article a WHERE a.language = :lan and a.status = :stat")		
//	List<Article> cquery(@Param("lan") String string1, @Param("stat") String string2);

	
    
}
