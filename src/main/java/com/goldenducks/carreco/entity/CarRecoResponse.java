package com.goldenducks.carreco.entity;

import java.util.List;

public class CarRecoResponse {
	
	private String title;
	
	private List<String> essentailSkills;
	
	private List<String> optionalSkills;
	
	private double payLow;
	
	private double payMedian;
	
	private double payHigh;
	
	private List<GlassDoorJobProgResponseNextJob> nextJobs;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getEssentialSkills() {
		return essentailSkills;
	}

	public void setEssentialSkills(List<String> essentialSkills) {
		this.essentailSkills = essentialSkills;
	}

	public List<String> getOptionalSkills() {
		return optionalSkills;
	}

	public void setOptionalSkills(List<String> optionalSkills) {
		this.optionalSkills = optionalSkills;
	}

	public double getPayLow() {
		return payLow;
	}

	public void setPayLow(double payLow) {
		this.payLow = payLow;
	}

	public double getPayMedian() {
		return payMedian;
	}

	public void setPayMedian(double payMedian) {
		this.payMedian = payMedian;
	}

	public double getPayHigh() {
		return payHigh;
	}

	public void setPayHigh(double payHigh) {
		this.payHigh = payHigh;
	}

	public List<GlassDoorJobProgResponseNextJob> getnextJobs() {
		return nextJobs;
	}

	public void setnextJobs(List<GlassDoorJobProgResponseNextJob> nextJobs) {
		this.nextJobs = nextJobs;
	}

}
