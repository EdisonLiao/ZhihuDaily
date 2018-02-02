package com.example.edisonliao.zhihudaily.entity;

import com.google.gson.annotations.SerializedName;

public class LastNewsTopStories {

	@SerializedName("image")
	private String image;

	@SerializedName("ga_prefix")
	private String gaPrefix;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private int type;

	@SerializedName("title")
	private String title;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
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