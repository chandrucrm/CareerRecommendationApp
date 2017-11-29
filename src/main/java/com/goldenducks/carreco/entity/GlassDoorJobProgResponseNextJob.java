package com.goldenducks.carreco.entity;

public class GlassDoorJobProgResponseNextJob {
	
	private String nextJobTitle;
    private double frequency;
    private double frequencyPercent;
    private int nationalJobCount;
    private double medianSalary;
	public String getNextJobTitle() {
		return nextJobTitle;
	}
	public void setNextJobTitle(String nextJobTitle) {
		this.nextJobTitle = nextJobTitle;
	}
	public double getFrequency() {
		return frequency;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	public double getFrequencyPercent() {
		return frequencyPercent;
	}
	public void setFrequencyPercent(double frequencyPercent) {
		this.frequencyPercent = frequencyPercent;
	}
	public int getNationalJobCount() {
		return nationalJobCount;
	}
	public void setNationalJobCount(int nationalJobCount) {
		this.nationalJobCount = nationalJobCount;
	}
	public double getMedianSalary() {
		return medianSalary;
	}
	public void setMedianSalary(double medianSalary) {
		this.medianSalary = medianSalary;
	}
    

}
