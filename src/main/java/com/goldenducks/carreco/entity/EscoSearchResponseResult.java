package com.goldenducks.carreco.entity;


public class EscoSearchResponseResult {
	
	private String className;
	private String title;
	private String uri;
	public EscoSearchResponseResult(String className, String title, String uri) {
		super();
		this.className = className;
		this.title = title;
		this.uri = uri;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
	