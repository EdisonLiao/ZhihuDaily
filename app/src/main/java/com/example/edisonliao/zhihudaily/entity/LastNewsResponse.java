package com.example.edisonliao.zhihudaily.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LastNewsResponse {

	@SerializedName("date")
	private String date;

	@SerializedName("top_stories")
	private List<LastNewsTopStories> topStories;

	@SerializedName("stories")
	private List<LastNewsStories> stories;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setTopStories(List<LastNewsTopStories> topStories){
		this.topStories = topStories;
	}

	public List<LastNewsTopStories> getTopStories(){
		return topStories;
	}

	public void setStories(List<LastNewsStories> stories){
		this.stories = stories;
	}

	public List<LastNewsStories> getStories(){
		return stories;
	}
}