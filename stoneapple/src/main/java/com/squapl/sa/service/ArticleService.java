package com.squapl.sa.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.squapl.sa.domain.Article;

public interface ArticleService {

	Article createArticle(Article article);

    List<Article> findAll();

    Article findArticle(Long id);


    }
