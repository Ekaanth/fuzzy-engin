package com.squapl.sa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idarticle;
	private String articlename;
	
	public Long getIdarticle() {
		return idarticle;
	}
	public void setIdarticle(Long idarticle) {
		this.idarticle = idarticle;
	}
	public String getArticlename() {
		return articlename;
	}
	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
	@Override
	public String toString() {
		return "Article [idarticle=" + idarticle + ", articlename=" + articlename + "]";
	}
	public Article(Long idarticle, String articlename) {
		
		this.idarticle = idarticle;
		this.articlename = articlename;
	}
	
	public Article(){
		super();
	}
	
	
}
