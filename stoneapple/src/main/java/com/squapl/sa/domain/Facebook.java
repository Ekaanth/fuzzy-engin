package com.squapl.sa.domain;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="facebook", type="facebook", shards=1,replicas=0)
public class Facebook {
	
	private String id;
	private String message;
	private String time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public Facebook(String id, String message, String time) {
		
		this.id = id;
		this.message = message;
		this.time = time;
	}
	
	public Facebook(){
		super();
	}
	

}
