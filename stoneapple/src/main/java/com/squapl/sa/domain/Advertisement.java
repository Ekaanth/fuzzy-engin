package com.squapl.sa.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="adds",type="adds",replicas=0,shards=1)
public class Advertisement {
	
	@Id
	private String id;
	private String name;
	private String discreption;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscreption() {
		return discreption;
	}
	public void setDiscreption(String discreption) {
		this.discreption = discreption;
	}
	
	public Advertisement(String id, String name, String discreption) {
		super();
		this.id = id;
		this.name = name;
		this.discreption = discreption;
	}	

}
