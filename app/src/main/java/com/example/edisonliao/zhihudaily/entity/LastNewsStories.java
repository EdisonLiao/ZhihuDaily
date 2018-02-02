package com.example.edisonliao.zhihudaily.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LastNewsStories {

	@SerializedName("images")
	private List<String> images;

	@SerializedName("ga_prefix")
	private String gaPrefix;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private int type;

	@SerializedName("title")
	private String title;

	public void setImages(List<String> images){
		this.images = images;
	}

	public List<String> getImages(){
		return images;
	}

	public void setGaPrefix(String gaPrefix){
		this.gaPrefix = gaPrefix;
	}

	public String getGaPrefix(){
		return gaPrefix;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}
}