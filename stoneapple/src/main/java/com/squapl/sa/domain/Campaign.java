package com.squapl.sa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String link;
    private String image;
    private String video;
    private String preference;
    private Date startdate;
    private Date enddate;
    private String tags;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "Campaign [id=" + id + ", name=" + name + ", description=" + description + ", link=" + link + ", image="
				+ image + ", video=" + video + ", preference=" + preference + ", startdate=" + startdate + ", enddate="
				+ enddate + ", tags=" + tags + "]";
	}
	public Campaign(Long id, String name, String description, String link, String image, String video,
			String preference, Date startdate, Date enddate, String tags) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.link = link;
		this.image = image;
		this.video = video;
		this.preference = preference;
		this.startdate = startdate;
		this.enddate = enddate;
		this.tags = tags;
	}
    
	public Campaign(){
		
	}
	
}


