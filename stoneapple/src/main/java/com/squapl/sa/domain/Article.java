package com.squapl.sa.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {

	 private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String language;
  
	private String title;
    private String r_title;
    private String description;
    private String read_time;
    private String body;
    private String category;
    private String tags;
    private String cover_img;
    private String article_img;
    private String status;
    private String article_bitly;
    private String created_by;
    private Timestamp published_time;
    
    

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	  public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRead_time() {
		return read_time;
	}
	public void setRead_time(String read_time) {
		this.read_time = read_time;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getCover_img() {
		return cover_img;
	}
	public void setCover_img(String cover_img) {
		this.cover_img = cover_img;
	}
	public String getArticle_img() {
		return article_img;
	}
	public void setArticle_img(String article_img) {
		this.article_img = article_img;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getArticle_bitly() {
		return article_bitly;
	}
	public void setArticle_bitly(String article_bitly) {
		this.article_bitly = article_bitly;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public Timestamp getPublished_time() {
		return published_time;
	}
	public void setPublished_time(Timestamp published_time) {
		this.published_time = published_time;
	}


	
  

	
    
    
}

