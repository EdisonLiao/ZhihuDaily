package com.example.edisonliao.zhihudaily.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NewsDetailResponse {

	@SerializedName("image")
	private String image;

	@SerializedName("images")
	private List<String> images;

	@SerializedName("css")
	private List<String> css;

	@SerializedName("share_url")
	private String shareUrl;

	@SerializedName("ga_prefix")
	private String gaPrefix;

	@SerializedName("js")
	private List<String> js;

	@SerializedName("section")
	private NewsDetailSection section;

	@SerializedName("id")
	private int id;

	@SerializedName("body")
	private String body;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private int type;

	@SerializedName("image_source")
	private String imageSource;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setImages(List<String> images){
		this.images = images;
	}

	public List<String> getImages(){
		return images;
	}

	public void setCss(List<String> css){
		this.css = css;
	}

	public List<String> getCss(){
		return css;
	}

	public void setShareUrl(String shareUrl){
		this.shareUrl = shareUrl;
	}

	public String getShareUrl(){
		return shareUrl;
	}

	public void setGaPrefix(String gaPrefix){
		this.gaPrefix = gaPrefix;
	}

	public String getGaPrefix(){
		return gaPrefix;
	}

	public void setJs(List<String> js){
		this.js = js;
	}

	public List<String> getJs(){
		return js;
	}

	public void setSection(NewsDetailSection section){
		this.section = section;
	}

	public NewsDetailSection getSection(){
		return section;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setImageSource(String imageSource){
		this.imageSource = imageSource;
	}

	public String getImageSource(){
		return imageSource;
	}
}