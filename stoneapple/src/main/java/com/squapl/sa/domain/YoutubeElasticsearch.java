package com.squapl.sa.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="youtube",type="youtube",shards=1,replicas=0)
public class YoutubeElasticsearch {

	@Id
	private String videoId;
	private String publishAt;
	private String channelId;
	private String title;
	private String description;
	private String imageurl;
	private String channelTitle;
	private String likecount;
	private String dislikecount;
	private String commentcount;
	private String viewcount;
	private String favoritecount;
	
	
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getPublishAt() {
		return publishAt;
	}
	public void setPublishAt(String publishAt) {
		this.publishAt = publishAt;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getChannelTitle() {
		return channelTitle;
	}
	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}
	public String getLikecount() {
		return likecount;
	}
	public void setLikecount(String likecount) {
		this.likecount = likecount;
	}
	public String getDislikecount() {
		return dislikecount;
	}
	public void setDislikecount(String dislikecount) {
		this.dislikecount = dislikecount;
	}
	public String getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(String commentcount) {
		this.commentcount = commentcount;
	}
	public String getViewcount() {
		return viewcount;
	}
	public void setViewcount(String viewcount) {
		this.viewcount = viewcount;
	}
	public String getFavoritecount() {
		return favoritecount;
	}
	public void setFavoritecount(String favoritecount) {
		this.favoritecount = favoritecount;
	}
	public YoutubeElasticsearch(String videoId, String publishAt, String channelId, String title, String description,
			String imageurl, String channelTitle, String likecount, String dislikecount, String commentcount,
			String viewcount, String favoritecount) {
		
		this.videoId = videoId;
		this.publishAt = publishAt;
		this.channelId = channelId;
		this.title = title;
		this.description = description;
		this.imageurl = imageurl;
		this.channelTitle = channelTitle;
		this.likecount = likecount;
		this.dislikecount = dislikecount;
		this.commentcount = commentcount;
		this.viewcount = viewcount;
		this.favoritecount = favoritecount;
	}
	
	
	public YoutubeElasticsearch(){
		super();
	}
}
