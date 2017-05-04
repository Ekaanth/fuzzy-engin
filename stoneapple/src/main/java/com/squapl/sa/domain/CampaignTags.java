package com.squapl.sa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CampaignTags {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String tags;
	
	

	public CampaignTags(Long id, String tags) {
		this.id = id;
		this.tags = tags;
	}



	@Override
	public String toString() {
		return "CampaignTags [id=" + id + ", tags=" + tags + "]";
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTags() {
		return tags;
	}



	public void setTags(String tags) {
		this.tags = tags;
	}



	public CampaignTags(){
		
	}
	
	
}
