package com.squapl.sa.jparepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.squapl.sa.domain.Article;

public interface ArticleDao extends CrudRepository<Article, Long> {

    List<Article> findAll();
}
