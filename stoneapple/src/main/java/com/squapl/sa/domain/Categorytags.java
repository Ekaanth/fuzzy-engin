package com.squapl.sa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="categorytags")

public class Categorytags {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categorytagsid;
	private String categoryname;
	private String tagsname;
	
	
	public Long getCategorytagsid() {
		return categorytagsid;
	}
	public void setCategorytagsid(Long categorytagsid) {
		this.categorytagsid = categorytagsid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getTagsname() {
		return tagsname;
	}
	public void setTagsname(String tagsname) {
		this.tagsname = tagsname;
	}
	
	
	
	
	
}
