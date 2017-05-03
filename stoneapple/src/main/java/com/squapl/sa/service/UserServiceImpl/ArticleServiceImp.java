package com.squapl.sa.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Article;
import com.squapl.sa.jparepository.ArticleDao;
import com.squapl.sa.service.ArticleService;

@Service
public class ArticleServiceImp implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public Article createArticle(Article article) {
		return articleDao.save(article);
	}

	@Override
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	@Override
	public Article findArticle(Long id) {
		return articleDao.findOne(id);
	}

	
	
}
