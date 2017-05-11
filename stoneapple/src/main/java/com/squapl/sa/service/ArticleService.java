package com.squapl.sa.service;

import java.util.List;

import com.squapl.sa.domain.Article;

public interface ArticleService {

	Article createArticle(Article article);

    List<Article> findAll();

    Article findArticle(Long id);
  
    List<Article> findByStatus(String status);

	//List<Article> findbystatuslanguage(String string, String string2);


    }
