package com.squapl.sa.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Article;
import com.squapl.sa.jparepository.ArticleDAO;
import com.squapl.sa.service.ArticleService;

@Service
public class ArticleServiceImp implements ArticleService{

	@Autowired
	private ArticleDAO articleDao;

	public Article createArticle(Article article) {
		return articleDao.save(article);
	}

	public List<Article> findAll() {
		return articleDao.findAll();
	}

	public Article findArticle(Long id) {
		return articleDao.findOne(id);
	}

	
	public List<Article> findByLanguage(String language) {
	
		return articleDao.findByLanguage(language);
	}

	
	public List<Article> findByStatus(String status) {
		
		return articleDao.findByStatus(status);
	}

	
//	public List<Article> findbystatuslanguage(String string1, String string2) {
//		
//		return articleDao.cquery(string1,string2);
//	}

	
	
}
