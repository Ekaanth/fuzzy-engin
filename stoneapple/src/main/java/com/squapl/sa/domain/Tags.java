package com.squapl.sa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tags {

	Tags(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long tagsid;
	private String tagsname;
	
	
	public Long getTagsid() {
		return tagsid;
	}
	public void setTagsid(Long tagsid) {
		this.tagsid = tagsid;
	}
	public String getTagsname() {
		return tagsname;
	}
	public void setTagsname(String tagsname) {
		this.tagsname = tagsname;
	}
	
	
}
